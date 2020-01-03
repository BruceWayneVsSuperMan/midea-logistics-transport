package com.midea.logistics.lpc.atomic.gen.service.common;

import com.midea.logistics.lpc.atomic.gen.mapper.GenAuthMapper;
import com.midea.logistics.lpc.domain.gen.entity.GenAuth;
import com.mideaframework.core.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class GenAuthService extends BaseService<GenAuthMapper, GenAuth> {

    public Integer demo() {
        return mapper.demo();
    }

}

