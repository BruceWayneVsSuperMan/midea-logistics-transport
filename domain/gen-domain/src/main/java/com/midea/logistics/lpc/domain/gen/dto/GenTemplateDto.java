package com.midea.logistics.lpc.domain.gen.dto;

import com.midea.logistics.lpc.domain.gen.entity.GenTemplate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * ©Copyright ©1968-2020 Midea Group,IT
 *
 * @author: DOP Group GEN
 * @table: gen_template (代码生成-模板) 实例扩展,代码生成不会覆盖
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GenTemplateDto extends GenTemplate {


    /**
     * model 转 Dto
     *
     * @param source
     * @return
     */
    public static GenTemplateDto copy(GenTemplate source) {
        GenTemplateDto target = new GenTemplateDto();
        GenTemplate.copy(source, target);
        return target;
    }
}
