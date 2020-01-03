package com.midea.logistics.lpc.converged.job.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "serviceId")
public interface DemoFeign {

    // Feign

}
