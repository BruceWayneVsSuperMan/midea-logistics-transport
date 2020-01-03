package com.midea.logistics.lpc.atomic.gen.service.common;

import com.midea.logistics.lpc.atomic.gen.mapper.GenTemplateMapper;
import com.midea.logistics.lpc.domain.gen.entity.GenTemplate;
import com.mideaframework.core.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class GenTemplateService extends BaseService<GenTemplateMapper, GenTemplate> {

    public Integer demo() {
        return mapper.demo();
    }

}

