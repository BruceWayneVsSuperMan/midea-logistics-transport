package com.midea.logistics.lpc.domain.gen.entity;

import com.mideaframework.core.bean.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * ©Copyright ©1968-2020 Midea Group,IT
 *
 * @author: DOP Group GEN
 * Description: gen_task (代码生成-任务) 数据库实体,自动生成,不可自行维护
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GenTask extends BaseDomain {

    /**
     * 自增长主键
     */
    private Long id;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 模板ID
     */
    private Long tempId;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 是否生成
     */
    private Integer needCreate;

    /**
     * 是否删除(本地模式有效)
     */
    private Integer needDelete;

    /**
     * 生产的文件后缀
     */
    private String fileSubfix;

    /**
     * 任务项目基本路径
     */
    private String projectBasePath;

    /**
     * 任务包路径
     */
    private String packagePath;

    /**
     * 任务变量
     */
    private String variables;

    /**
     * 任务描述
     */
    private String taskDesc;


    public static GenTask copy(GenTask source, GenTask target) {
        if (target == null) {
            target = new GenTask();
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
        target.setTempId(source.getTempId());
        target.setTaskName(source.getTaskName());
        target.setNeedCreate(source.getNeedCreate());
        target.setNeedDelete(source.getNeedDelete());
        target.setFileSubfix(source.getFileSubfix());
        target.setProjectBasePath(source.getProjectBasePath());
        target.setPackagePath(source.getPackagePath());
        target.setVariables(source.getVariables());
        target.setTaskDesc(source.getTaskDesc());
        return target;
    }

    public static GenTask copyIfNotNull(GenTask source, GenTask target) {
        if (target == null) {
            target = new GenTask();
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
        if (source.getTempId() != null) {
            target.setTempId(source.getTempId());
        }
        if (source.getTaskName() != null) {
            target.setTaskName(source.getTaskName());
        }
        if (source.getNeedCreate() != null) {
            target.setNeedCreate(source.getNeedCreate());
        }
        if (source.getNeedDelete() != null) {
            target.setNeedDelete(source.getNeedDelete());
        }
        if (source.getFileSubfix() != null) {
            target.setFileSubfix(source.getFileSubfix());
        }
        if (source.getProjectBasePath() != null) {
            target.setProjectBasePath(source.getProjectBasePath());
        }
        if (source.getPackagePath() != null) {
            target.setPackagePath(source.getPackagePath());
        }
        if (source.getVariables() != null) {
            target.setVariables(source.getVariables());
        }
        if (source.getTaskDesc() != null) {
            target.setTaskDesc(source.getTaskDesc());
        }
        return target;
    }

}
