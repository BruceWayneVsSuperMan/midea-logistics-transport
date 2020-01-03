package com.midea.logistics.lpc.converged.task.feign;

import com.mideaframework.core.web.JsonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "logistics-transport-gen-atomic")
public interface DemoFeign {

    @GetMapping("/demo")
    JsonResponse<String> demo();

}
