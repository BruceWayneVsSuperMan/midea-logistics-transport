package com.midea.logistics.lpc.atomic.gen.service.common;

import com.midea.logistics.lpc.atomic.gen.mapper.GenTaskMapper;
import com.midea.logistics.lpc.domain.gen.entity.GenTask;
import com.mideaframework.core.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class GenTaskService extends BaseService<GenTaskMapper, GenTask> {

    public Integer demo() {
        return mapper.demo();
    }

}

