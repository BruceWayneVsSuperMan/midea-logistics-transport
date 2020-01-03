package com.midea.logistics.lpc.atomic.gen.pojo;

import com.midea.logistics.lpc.domain.gen.entity.GenDatabase;
import lombok.Data;

import java.util.List;

@Data
public class DatabaseConfig {

    private String databaseName;
    private String driverClass;
    private String connectionURL;
    private String username;
    private String password;
    private Integer selected;

    /**
     * 需要忽略的表
     */
    private String ignoreTables;

    /**
     * 需要忽略的字段
     */
    private String ignoreCloumns;

    /**
     * 表前缀（筛选表）
     */
    private String prefix;

    /**
     * 表
     */
    private List<Table> tables;


    // 辅助内容
    private String connectionURLTransference;

    private String driverJarPath;


    /**
     * 获取数据源信息
     *
     * @param genDatabase
     * @return
     */
    public static DataSource getDataSource(GenDatabase genDatabase) {
        DataSource dataSource = new DataSource();

        dataSource.setUrl(genDatabase.getConnectionUrl());
        dataSource.setDriverClassName(genDatabase.getDriverClass());
        dataSource.setUsername(genDatabase.getUsername());
        dataSource.setPassword(genDatabase.getPassword());
        return dataSource;
    }

}
