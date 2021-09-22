package com.github.tnessn.fcloud.a.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "fcloud-a-service")
public interface AService{
	
	@GetMapping(value="/inner/a/helloA")
    String helloA(@RequestParam String name);
}