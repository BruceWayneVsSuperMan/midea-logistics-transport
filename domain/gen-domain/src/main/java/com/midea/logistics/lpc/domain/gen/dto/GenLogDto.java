package com.midea.logistics.lpc.domain.gen.dto;

import com.midea.logistics.lpc.domain.gen.entity.GenLog;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * ©Copyright ©1968-2020 Midea Group,IT
 *
 * @author: DOP Group GEN
 * @table: gen_log (代码生成-日志) 实例扩展,代码生成不会覆盖
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GenLogDto extends GenLog {


    /**
     * model 转 Dto
     *
     * @param source
     * @return
     */
    public static GenLogDto copy(GenLog source) {
        GenLogDto target = new GenLogDto();
        GenLog.copy(source, target);
        return target;
    }
}
