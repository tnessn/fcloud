package org.fcloud.feign.consumer.service;


import org.fcloud.api.HelloApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("hello-service")
public interface HelloService extends HelloApi  {
}