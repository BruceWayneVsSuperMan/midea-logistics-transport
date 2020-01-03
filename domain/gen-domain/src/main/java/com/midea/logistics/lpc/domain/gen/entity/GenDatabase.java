package com.midea.logistics.lpc.domain.gen.entity;

import com.mideaframework.core.bean.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * ©Copyright ©1968-2020 Midea Group,IT
 *
 * @author: DOP Group GEN
 * Description: gen_database (代码生成-数据库) 数据库实体,自动生成,不可自行维护
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GenDatabase extends BaseDomain {

    /**
     * 自增长主键
     */
    private Long id;

    /**
     * 项目id, 关联gen_project表id
     */
    private Long projectId;

    /**
     * 数据库链接
     */
    private String connectionUrl;

    /**
     * 数据库驱动地址
     */
    private String driverClass;

    /**
     * 数据库名称
     */
    private String databaseName;

    /**
     * 数据库用户名
     */
    private String username;

    /**
     * 数据库密码
     */
    private String password;

    /**
     * 表前缀
     */
    private String prefix;

    /**
     * 生效的表,英文逗号分隔
     */
    private String effectiveTables;

    /**
     * 忽略的字段,英文逗号分隔
     */
    private String ignoreCloumns;


    public static GenDatabase copy(GenDatabase source, GenDatabase target) {
        if (target == null) {
            target = new GenDatabase();
        }
        if (source == null) {
            return target;
        }
        target.setId(source.getId());
        target.setCreateUserCode(source.getCreateUserCode());
        target.setCreateTime(source.getCreateTime());
        target.setUpdateUserCode(source.getUpdateUserCode());
        target.setUpdateTime(source.getUpdateTime());
        target.setDeleteFlag(source.getDeleteFlag());
        target.setVersion(source.getVersion());
        target.setRemark(source.getRemark());
        target.setProjectId(source.getProjectId());
        target.setConnectionUrl(source.getConnectionUrl());
        target.setDriverClass(source.getDriverClass());
        target.setDatabaseName(source.getDatabaseName());
        target.setUsername(source.getUsername());
        target.setPassword(source.getPassword());
        target.setPrefix(source.getPrefix());
        target.setEffectiveTables(source.getEffectiveTables());
        target.setIgnoreCloumns(source.getIgnoreCloumns());
        return target;
    }

    public static GenDatabase copyIfNotNull(GenDatabase source, GenDatabase target) {
        if (target == null) {
            target = new GenDatabase();
        }
        if (source == null) {
            return target;
        }
        if (source.getId() != null) {
            target.setId(source.getId());
        }
        if (source.getCreateUserCode() != null) {
            target.setCreateUserCode(source.getCreateUserCode());
        }
        if (source.getCreateTime() != null) {
            target.setCreateTime(source.getCreateTime());
        }
        if (source.getUpdateUserCode() != null) {
            target.setUpdateUserCode(source.getUpdateUserCode());
        }
        if (source.getUpdateTime() != null) {
            target.setUpdateTime(source.getUpdateTime());
        }
        if (source.getDeleteFlag() != null) {
            target.setDeleteFlag(source.getDeleteFlag());
        }
        if (source.getVersion() != null) {
            target.setVersion(source.getVersion());
        }
        if (source.getRemark() != null) {
            target.setRemark(source.getRemark());
        }
        if (source.getProjectId() != null) {
            target.setProjectId(source.getProjectId());
        }
        if (source.getConnectionUrl() != null) {
            target.setConnectionUrl(source.getConnectionUrl());
        }
        if (source.getDriverClass() != null) {
            target.setDriverClass(source.getDriverClass());
        }
        if (source.getDatabaseName() != null) {
            target.setDatabaseName(source.getDatabaseName());
        }
        if (source.getUsername() != null) {
            target.setUsername(source.getUsername());
        }
        if (source.getPassword() != null) {
            target.setPassword(source.getPassword());
        }
        if (source.getPrefix() != null) {
            target.setPrefix(source.getPrefix());
        }
        if (source.getEffectiveTables() != null) {
            target.setEffectiveTables(source.getEffectiveTables());
        }
        if (source.getIgnoreCloumns() != null) {
            target.setIgnoreCloumns(source.getIgnoreCloumns());
        }
        return target;
    }

}
