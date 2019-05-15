package org.fcloud.api.service;


import org.fcloud.api.HelloApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("fcloud-provider")
public interface HelloService extends HelloApi  {
}