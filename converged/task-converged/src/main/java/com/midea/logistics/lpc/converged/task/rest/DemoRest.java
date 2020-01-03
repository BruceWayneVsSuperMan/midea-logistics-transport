package com.midea.logistics.lpc.converged.task.rest;

import com.midea.logistics.lpc.converged.task.feign.DemoFeign;
import com.mideaframework.core.web.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRest {

    @Autowired
    private DemoFeign demoFeign;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/demo")
    public JsonResponse demo() {
        JsonResponse<String> response = demoFeign.demo();
        String serviceName = response.getData();

        String application = applicationName + "-->" + serviceName;
        response.setData(application);

        return response;
    }

}
