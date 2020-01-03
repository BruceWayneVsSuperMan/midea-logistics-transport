package com.midea.logistics.lpc.domain.gen.entity;

import com.mideaframework.core.bean.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * ©Copyright ©1968-2020 Midea Group,IT
 *
 * @author: DOP Group GEN
 * Description: gen_auth (代码生成-授权) 数据库实体,自动生成,不可自行维护
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GenAuth extends BaseDomain {

    /**
     * 自增长主键
     */
    private Long id;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 授权码
     */
    private String authCode;


    public static GenAuth copy(GenAuth source, GenAuth target) {
        if (target == null) {
            target = new GenAuth();
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
        target.setAuthCode(source.getAuthCode());
        return target;
    }

    public static GenAuth copyIfNotNull(GenAuth source, GenAuth target) {
        if (target == null) {
            target = new GenAuth();
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
        if (source.getAuthCode() != null) {
            target.setAuthCode(source.getAuthCode());
        }
        return target;
    }

}
