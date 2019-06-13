package org.fcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

@SpringBootApplication
@EnableDiscoveryClient
@EnableApolloConfig // 开启Apollo客户端
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}