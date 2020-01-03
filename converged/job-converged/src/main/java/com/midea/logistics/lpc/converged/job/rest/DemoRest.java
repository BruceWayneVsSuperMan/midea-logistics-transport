package com.midea.logistics.lpc.converged.job.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRest {

    @GetMapping("/demo")
    public String demo() {
        return "OK";
    }

}
