package com.midea.logistics.lpc.atomic.gen.service.common;

import com.midea.logistics.lpc.atomic.gen.mapper.GenLogMapper;
import com.midea.logistics.lpc.domain.gen.entity.GenLog;
import com.mideaframework.core.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class GenLogService extends BaseService<GenLogMapper, GenLog> {

    public Integer demo() {
        return mapper.demo();
    }

}

