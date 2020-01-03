package com.midea.logistics.lpc.atomic.gen.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProjectInfo {

    /*
     **************** 项目信息 ****************
     */
    /**
     * 项目域
     */
    @NotNull
    private String projectDomain;

    /**
     * 项目名称
     */
    @NotNull
    private String projectName;

    /*
     **************** 数据库信息 ****************
     */
    /**
     * 数据库链接
     */
    @NotNull
    private String connectionUrl;

    /**
     * 数据库名称
     */
    @NotNull
    private String databaseName;

    /**
     * 数据库用户名
     */
    @NotNull
    private String username;

    /**
     * 数据库密码
     */
    @NotNull
    private String password;

    /**
     * 表前缀
     */
    @NotNull
    private String prefix;

    /*
     **************** 规则信息 ****************
     */
    /*
     * 子模块名称
     */
    @NotNull
    private String subModule;

    /*
     * 用于生成feign的服务id
     */
    @NotNull
    private String feignServiceId;

}
