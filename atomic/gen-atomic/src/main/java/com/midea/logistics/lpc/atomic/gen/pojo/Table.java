package com.midea.logistics.lpc.atomic.gen.pojo;

import com.midea.logistics.lpc.atomic.gen.util.StringUtil;
import lombok.Data;

import java.util.List;

@Data
public class Table {

    /**
     * 下划线表名
     */
    private String nameUnderLine;

    /**
     * 小写驼峰表名
     */
    private String nameLowerCaseCamel;

    /**
     * 大写驼峰表名
     */
    private String nameUpperCaseCamel;

    /**
     * 表备注
     */
    private String remarks;


    // 辅助信息


    /**
     * controller 路径
     */
    private String restPath;

    /**
     * controller 组
     */
    private String restGroup;


    /**
     * 忽略字段没有 Blob
     */

    /**
     * 表下的字段【不包含忽略的字段，不包含Blob字段】
     */
    private List<Column> columns;

    /**
     * 表下的字段【不包含忽略的字段，包含Blob字段】
     */
    private List<Column> columnsWithBlob;

    /**
     * 表下的字段【仅包含Blob字段, 不包含忽略的字段】
     */
    private List<Column> columnsOnlyBlobNotIgnore;

    /**
     * 表下的字段【包含忽略的字段，不包含Blob字段】
     */
    private List<Column> columnsWithIgnore;

    /**
     * 表下的字段【包含忽略的字段，包含Blob字段】
     */
    private List<Column> columnsWithAll;


    public void setNameUnderLine(String nameUnderLine) {
        this.nameUnderLine = nameUnderLine;
        this.nameLowerCaseCamel = StringUtil.underlineToCamel(this.nameUnderLine);
        this.nameUpperCaseCamel = StringUtil.firstChatToUpperCase(this.nameLowerCaseCamel);
    }
}
