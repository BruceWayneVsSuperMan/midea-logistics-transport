package com.midea.logistics.lpc.domain.gen.dto;

import com.midea.logistics.lpc.domain.gen.entity.GenAuth;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * ©Copyright ©1968-2020 Midea Group,IT
 *
 * @author: DOP Group GEN
 * @table: gen_auth (代码生成-授权) 实例扩展,代码生成不会覆盖
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GenAuthDto extends GenAuth {


    /**
     * model 转 Dto
     *
     * @param source
     * @return
     */
    public static GenAuthDto copy(GenAuth source) {
        GenAuthDto target = new GenAuthDto();
        GenAuth.copy(source, target);
        return target;
    }
}
