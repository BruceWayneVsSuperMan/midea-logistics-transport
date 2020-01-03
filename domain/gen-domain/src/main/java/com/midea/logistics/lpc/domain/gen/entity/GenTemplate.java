package com.midea.logistics.lpc.domain.gen.entity;

import com.mideaframework.core.bean.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * ©Copyright ©1968-2020 Midea Group,IT
 *
 * @author: DOP Group GEN
 * Description: gen_template (代码生成-模板) 数据库实体,自动生成,不可自行维护
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GenTemplate extends BaseDomain {

    /**
     * 自增长主键
     */
    private Long id;

    /**
     * 模板名称
     */
    private String ftlName;

    /**
     * 生成的文件后缀
     */
    private String fileSubfix;

    /**
     * 模板描述
     */
    private String ftlDesc;

    /**
     * 模板变量
     */
    private String variables;

    /**
     * 模板内容
     */
    private String tempContent;


    public static GenTemplate copy(GenTemplate source, GenTemplate target) {
        if (target == null) {
            target = new GenTemplate();
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
        target.setFtlName(source.getFtlName());
        target.setFileSubfix(source.getFileSubfix());
        target.setFtlDesc(source.getFtlDesc());
        target.setVariables(source.getVariables());
        target.setTempContent(source.getTempContent());
        return target;
    }

    public static GenTemplate copyIfNotNull(GenTemplate source, GenTemplate target) {
        if (target == null) {
            target = new GenTemplate();
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
        if (source.getFtlName() != null) {
            target.setFtlName(source.getFtlName());
        }
        if (source.getFileSubfix() != null) {
            target.setFileSubfix(source.getFileSubfix());
        }
        if (source.getFtlDesc() != null) {
            target.setFtlDesc(source.getFtlDesc());
        }
        if (source.getVariables() != null) {
            target.setVariables(source.getVariables());
        }
        if (source.getTempContent() != null) {
            target.setTempContent(source.getTempContent());
        }
        return target;
    }

}
