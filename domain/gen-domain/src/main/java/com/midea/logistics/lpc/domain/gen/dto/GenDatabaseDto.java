package com.midea.logistics.lpc.domain.gen.dto;

import com.midea.logistics.lpc.domain.gen.entity.GenDatabase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * ©Copyright ©1968-2020 Midea Group,IT
 *
 * @author: DOP Group GEN
 * @table: gen_database (代码生成-数据库) 实例扩展,代码生成不会覆盖
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GenDatabaseDto extends GenDatabase {


    /**
     * model 转 Dto
     *
     * @param source
     * @return
     */
    public static GenDatabaseDto copy(GenDatabase source) {
        GenDatabaseDto target = new GenDatabaseDto();
        GenDatabase.copy(source, target);
        return target;
    }
}
