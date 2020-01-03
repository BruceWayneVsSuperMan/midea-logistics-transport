package com.midea.logistics.lpc.converged.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableEurekaClient
@EnableScheduling
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients(value = {"com.midea.logistics.lpc.domain", "com.midea.logistics.lpc.converged.job.feign"})

public class JobConvergedApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobConvergedApplication.class, args);
    }

}
