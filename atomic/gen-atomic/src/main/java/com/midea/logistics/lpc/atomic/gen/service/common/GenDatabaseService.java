package com.midea.logistics.lpc.atomic.gen.service.common;

import com.midea.logistics.lpc.atomic.gen.mapper.GenDatabaseMapper;
import com.midea.logistics.lpc.domain.gen.entity.GenDatabase;
import com.mideaframework.core.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class GenDatabaseService extends BaseService<GenDatabaseMapper, GenDatabase> {

    public Integer demo() {
        return mapper.demo();
    }

}

