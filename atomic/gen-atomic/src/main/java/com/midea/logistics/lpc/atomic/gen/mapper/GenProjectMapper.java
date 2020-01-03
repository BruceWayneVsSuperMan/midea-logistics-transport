package com.midea.logistics.lpc.atomic.gen.mapper;

import com.midea.logistics.lpc.domain.gen.entity.GenProject;
import com.mideaframework.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GenProjectMapper extends BaseMapper<GenProject> {

    // 示例查询,可删除
    Integer demo();

}

