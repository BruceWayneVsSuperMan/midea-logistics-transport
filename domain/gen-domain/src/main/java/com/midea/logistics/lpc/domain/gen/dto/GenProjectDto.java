package com.midea.logistics.lpc.domain.gen.dto;

import com.midea.logistics.lpc.domain.gen.entity.GenProject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * ©Copyright ©1968-2020 Midea Group,IT
 *
 * @author: DOP Group GEN
 * @table: gen_project (代码生成-项目) 实例扩展,代码生成不会覆盖
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GenProjectDto extends GenProject {


    private String distPath;


    /**
     * model 转 Dto
     *
     * @param source
     * @return
     */
    public static GenProjectDto copy(GenProject source) {
        GenProjectDto target = new GenProjectDto();
        GenProject.copy(source, target);
        return target;
    }
}
