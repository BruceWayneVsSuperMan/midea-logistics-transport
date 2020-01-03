package com.midea.logistics.lpc.application.pc.feign;

import com.mideaframework.core.web.JsonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "logistics-demo-task-converge")
public interface DemoFeign {

    @GetMapping("/demo")
    JsonResponse<String> demo();

}
