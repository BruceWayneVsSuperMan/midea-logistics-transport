package com.midea.logistics.lpc.converged.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableEurekaClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients(value = {"com.midea.logistics.lpc.domain", "com.midea.logistics.lpc.converged.task.feign"})
public class TaskConvergedApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskConvergedApplication.class, args);
    }

}
