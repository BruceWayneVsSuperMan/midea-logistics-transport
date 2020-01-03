package com.midea.logistics.lpc.atomic.gen.service.common;

import com.midea.logistics.lpc.atomic.gen.mapper.GenProjectMapper;
import com.midea.logistics.lpc.domain.gen.entity.GenProject;
import com.mideaframework.core.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class GenProjectService extends BaseService<GenProjectMapper, GenProject> {

    public Integer demo() {
        return mapper.demo();
    }

}

