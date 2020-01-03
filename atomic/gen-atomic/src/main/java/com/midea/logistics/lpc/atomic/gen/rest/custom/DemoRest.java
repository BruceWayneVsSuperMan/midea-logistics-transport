package com.midea.logistics.lpc.atomic.gen.rest.custom;

import com.midea.logistics.lpc.atomic.gen.rest.Routers;
import com.midea.logistics.lpc.atomic.gen.service.common.GenTemplateService;
import com.midea.logistics.lpc.domain.gen.entity.GenTemplate;
import com.mideaframework.core.web.JsonResponse;
import com.mideaframework.core.web.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${info.author}")
    private String author;

    @Autowired
    private GenTemplateService genTemplateService;


    @GetMapping("/demo")
    public JsonResponse demo() {
        String appName = author + ":" + applicationName;
        JsonResponse<Object> response = JsonResponse.success(appName);
        return response;
    }


    @GetMapping(Routers.DEMO_TEST)
    public PageResponse demoTest() {
        PageResponse<GenTemplate> page = genTemplateService.page(new GenTemplate());
        return page;
    }

}
