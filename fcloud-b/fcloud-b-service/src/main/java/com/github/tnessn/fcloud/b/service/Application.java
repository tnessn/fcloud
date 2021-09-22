package com.github.tnessn.fcloud.b.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.github.tnessn.fcloud.a.api"})
@ImportResource(locations = "classpath:dubbo.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}