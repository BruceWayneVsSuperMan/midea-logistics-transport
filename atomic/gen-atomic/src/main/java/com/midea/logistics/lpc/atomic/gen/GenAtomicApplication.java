package com.midea.logistics.lpc.atomic.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GenAtomicApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenAtomicApplication.class, args);
    }

}
