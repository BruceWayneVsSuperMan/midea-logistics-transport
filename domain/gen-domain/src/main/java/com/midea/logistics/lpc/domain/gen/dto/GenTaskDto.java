package com.midea.logistics.lpc.domain.gen.dto;

import com.midea.logistics.lpc.domain.gen.entity.GenTask;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * ©Copyright ©1968-2020 Midea Group,IT
 *
 * @author: DOP Group GEN
 * @table: gen_task (代码生成-任务) 实例扩展,代码生成不会覆盖
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GenTaskDto extends GenTask {


    private String packagePathWithSlantLine;

    /**
     * model 转 Dto
     *
     * @param source
     * @return
     */
    public static GenTaskDto copy(GenTask source) {
        GenTaskDto target = new GenTaskDto();
        GenTask.copy(source, target);
        return target;
    }
}
