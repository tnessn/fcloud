package org.fcloud.feign.consumer.service;


import org.fcloud.api.service.IHelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("hello-service")
public interface HelloService extends IHelloService  {
}