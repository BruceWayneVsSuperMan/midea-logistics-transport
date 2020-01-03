package com.midea.logistics.lpc.atomic.gen.pojo;

import com.midea.logistics.lpc.atomic.gen.util.StringUtil;
import lombok.Data;

@Data
public class Column {

    /**
     * 下划线字段名
     */
    private String nameUnderLine;

    /**
     * 小写驼峰字段名
     */
    private String nameLowerCaseCamel;

    /**
     * 大写驼峰字段名
     */
    private String nameUpperCaseCamel;

    /**
     * mysql 类型名称
     */
    private String mysqlType;

    /**
     * java 类型
     */
    private String javaType;

    /**
     * 字段 备注
     */
    private String remarks;

    public void setNameUnderLine(String nameUnderLine) {
        this.nameUnderLine = nameUnderLine;
        this.nameLowerCaseCamel = StringUtil.underlineToCamel(this.nameUnderLine);
        this.nameUpperCaseCamel = StringUtil.firstChatToUpperCase(this.nameLowerCaseCamel);
    }

    public static String getJavaType(String mysqlType) {

        // Boolean : BIT
        if ("BIT".equals(mysqlType)) {
            return "Boolean";
        }

        // Integer : INT,INTEGER,MEDIUMINT
        if ("INT".equals(mysqlType) || "INTEGER".equals(mysqlType) || "MEDIUMINT".equals(mysqlType)) {
            return "Integer";
        }
        // Long : BIGINT
        if ("BIGINT".equals(mysqlType)) {
            return "Long";
        }
        // Float : FLOAT
        if ("FLOAT".equals(mysqlType)) {
            return "Float";
        }
        // Double : DOUBLE,REAL
        if ("DOUBLE".equals(mysqlType) || "REAL".equals(mysqlType)) {
            return "Double";
        }
        // String : CHAR,VARCHAR,TEXT,MEDIUMTEXT,TINYTEXT,LONGTEXT,JSON
        if ("CHAR".equals(mysqlType) || "VARCHAR".equals(mysqlType) || "TEXT".equals(mysqlType) || "MEDIUMTEXT".equals(mysqlType) || "TINYTEXT".equals(mysqlType) || "LONGTEXT".equals(mysqlType) || "JSON".equals(mysqlType)) {
            return "String";
        }
        // Date : TIME,DATE,DATETIME,TIMESTAMP,YEAR 【需要 import】
        if ("TIME".equals(mysqlType) || "DATE".equals(mysqlType) || "DATETIME".equals(mysqlType) || "TIMESTAMP".equals(mysqlType) || "YEAR".equals(mysqlType)) {
            return "Date";
        }
        // BigDecimal : DECIMAL,NUMERIC 【需要 import】
        if ("DECIMAL".equals(mysqlType) || "NUMERIC".equals(mysqlType)) {
            return "BigDecimal";
        }
        // Byte : TINYINT
        if ("TINYINT".equals(mysqlType)) {
            return "Byte";
        }
        // Byte[] : BINARY,BLOB,GEOMETRY,LONGBLOB,MEDIUMBLOB,TINYBLOB,VARBINARY
        if ("BINARY".equals(mysqlType) || "BLOB".equals(mysqlType) || "GEOMETRY".equals(mysqlType) || "LONGBLOB".equals(mysqlType) || "MEDIUMBLOB".equals(mysqlType) || "TINYBLOB".equals(mysqlType) || "VARBINARY".equals(mysqlType)) {
            return "byte[]";
        }

        // Object : GEOMETRYCOLLECTION,LINESTRING,MULTILINESTRING,MULTIPOINT,MULTIPOLYGON,POINT,POLYGON,不考虑的类型：ENUM,SET,SMALLINT
        return "Object";

    }

}
