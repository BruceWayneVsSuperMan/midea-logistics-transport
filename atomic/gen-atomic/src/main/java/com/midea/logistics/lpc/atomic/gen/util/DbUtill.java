package com.midea.logistics.lpc.atomic.gen.util;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.midea.logistics.lpc.atomic.gen.helper.JdbcHelper;
import com.midea.logistics.lpc.atomic.gen.pojo.Column;
import com.midea.logistics.lpc.atomic.gen.pojo.DataSource;
import com.midea.logistics.lpc.atomic.gen.pojo.DatabaseConfig;
import com.midea.logistics.lpc.atomic.gen.pojo.Table;
import com.midea.logistics.lpc.domain.gen.entity.GenDatabase;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DbUtill {

    private static final Logger logger = LoggerFactory.getLogger(DbUtill.class);
    private static List<String> BIG_COLUMNS = Arrays.asList(new String[]{
        "LONGTEXT",
        "MEDIUMTEXT",
        "TEXT",
        "BINARY",
        "BLOB",
        "GEOMETRY",
        "LONGBLOB",
        "MEDIUMBLOB",
        "TINYBLOB",
        "VARBINARY"
    });

    public static List<Table> getTables(GenDatabase database) {

        // 不需要理会的表
        List<String> ignoreTables = DbUtill.string2List(database.getIgnoreCloumns());
        if (ignoreTables == null) {
            ignoreTables = new ArrayList<String>();
        }

        // 需要筛选出来的表
        List<String> effectiveTables = DbUtill.string2List(database.getEffectiveTables());
        if (effectiveTables == null) {
            effectiveTables = new ArrayList<String>();
        }

        // 需要筛选的表前缀
        String prefix = database.getPrefix();
        logger.info("获取表: {}", DateUtil.getYyyyMmDdHhMmSsSss(System.currentTimeMillis()));

        // 获取 Table
        DruidPooledConnection conn = DataSource.getConnect(DatabaseConfig.getDataSource(database));
        List<Table> tables = new ArrayList<>();

        // 获取表
        String sql = "SELECT table_name, table_comment FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = '" + database.getDatabaseName() + "'";
        List<Map> tabInfos = JdbcHelper.jdbcExecutor(conn, sql);
        for (Map tabInfo : tabInfos) {

            Table table = new Table();
            table.setNameUnderLine(tabInfo.get("tableName").toString());

            // 跳过忽略的表
            if (ignoreTables.contains(table.getNameUnderLine())) {
                continue;
            }

            // 如果 不是指定表前缀, 并且 不是需要筛选出来的表
            if ((StringUtils.isNotBlank(prefix) && !table.getNameUnderLine().startsWith(prefix))
                && (!effectiveTables.contains(table.getNameUnderLine()))
            ) {
                continue;
            }

            // rest 相关数据准备
            table.setRestPath("/" + table.getNameUnderLine().replace("_", "/"));
            table.setRestGroup(table.getNameUnderLine().toUpperCase());

            Object value = tabInfo.get("tableComment");
            table.setRemarks(value == null ? "unknown" : value.toString());
            tables.add(table);
        }

        return tables;
    }

    public static List<Column> getColums(GenDatabase database, Table table) {

        // 不需要理会的字段
        List<String> ignoreColumns = DbUtill.string2List(database.getIgnoreCloumns());
        if (ignoreColumns == null) {
            ignoreColumns = new ArrayList<>();
        }

        logger.info("获取表字段 {} : {}", DateUtil.getYyyyMmDdHhMmSsSss(System.currentTimeMillis()), table.getNameUnderLine());

        List<Column> columns = new ArrayList<>();
        List<Column> columnsWithBlob = new ArrayList<>();
        List<Column> columnsOnlyBlobNotIgnore = new ArrayList<>();
        List<Column> columnsWithIgnore = new ArrayList<>();
        List<Column> columnsWithAll = new ArrayList<>();


        DruidPooledConnection conn = DataSource.getConnect(DatabaseConfig.getDataSource(database));

        String sql = "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT REMARKS FROM information_schema.COLUMNS WHERE " +
            "TABLE_SCHEMA = '" + database.getDatabaseName() + "' " +
            "AND TABLE_NAME = '" + table.getNameUnderLine() + "'";

        List<Map> columnInfos = JdbcHelper.jdbcExecutor(conn, sql);

        for (Map columnInfo : columnInfos) {

            String columnName = columnInfo.get("COLUMNNAME").toString();
            String typeName = columnInfo.get("DATATYPE").toString().toUpperCase();

            // 不知道为什么，结果集就重复了
            boolean exist = false;
            for (Column column : columns) {
                if (columnName.equalsIgnoreCase(column.getNameUnderLine())) {
                    exist = true;
                    break;
                }
            }
            if (exist) {
                continue;
            }
            Column column = new Column();
            column.setNameUnderLine(columnName);
            column.setMysqlType(typeName);
            column.setJavaType(Column.getJavaType(typeName));
            column.setRemarks(columnInfo.get("REMARKS") == null ? null : columnInfo.get("REMARKS").toString());

            columnsWithAll.add(column);
            if (!BIG_COLUMNS.contains(typeName)) {
                columnsWithIgnore.add(column);
            }
            if (!ignoreColumns.contains(columnName)) {
                columnsWithBlob.add(column);
            }
            if (BIG_COLUMNS.contains(typeName) && !ignoreColumns.contains(columnName)) {
                columnsOnlyBlobNotIgnore.add(column);
            }
            if (!BIG_COLUMNS.contains(typeName) && !ignoreColumns.contains(columnName)) {
                columns.add(column);
            }

        }
        table.setColumns(columns);
        table.setColumnsWithBlob(columnsWithBlob);
        table.setColumnsWithIgnore(columnsWithIgnore);
        table.setColumnsOnlyBlobNotIgnore(columnsOnlyBlobNotIgnore);
        table.setColumnsWithAll(columnsWithAll);

        return columns;

    }


    private static List<String> string2List(String str) {
        if (StringUtils.isBlank(str)) {
            return new ArrayList<>();
        }
        str = str.replaceAll(" ", "");
        String[] ignoreCls = str.split(",");
        return Arrays.asList(ignoreCls);
    }

}
