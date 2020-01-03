package com.midea.logistics.lpc.domain.gen.entity;

import com.mideaframework.core.bean.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * ©Copyright ©1968-2020 Midea Group,IT
 *
 * @author: DOP Group GEN
 * Description: gen_project (代码生成-项目) 数据库实体,自动生成,不可自行维护
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GenProject extends BaseDomain {

    /**
     * 自增长主键
     */
    private Long id;

    /**
     * 基础包路径
     */
    private String commonLib;

    /**
     * 项目域
     */
    private String projectDomain;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目说明
     */
    private String projectDesc;

    /**
     * 数据库驱动路径(服务器情况使用)
     */
    private String dbDriverPath;


    public static GenProject copy(GenProject source, GenProject target) {
        if (target == null) {
            target = new GenProject();
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
        target.setCommonLib(source.getCommonLib());
        target.setProjectDomain(source.getProjectDomain());
        target.setProjectName(source.getProjectName());
        target.setProjectDesc(source.getProjectDesc());
        target.setDbDriverPath(source.getDbDriverPath());
        return target;
    }

    public static GenProject copyIfNotNull(GenProject source, GenProject target) {
        if (target == null) {
            target = new GenProject();
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
        if (source.getCommonLib() != null) {
            target.setCommonLib(source.getCommonLib());
        }
        if (source.getProjectDomain() != null) {
            target.setProjectDomain(source.getProjectDomain());
        }
        if (source.getProjectName() != null) {
            target.setProjectName(source.getProjectName());
        }
        if (source.getProjectDesc() != null) {
            target.setProjectDesc(source.getProjectDesc());
        }
        if (source.getDbDriverPath() != null) {
            target.setDbDriverPath(source.getDbDriverPath());
        }
        return target;
    }

}
