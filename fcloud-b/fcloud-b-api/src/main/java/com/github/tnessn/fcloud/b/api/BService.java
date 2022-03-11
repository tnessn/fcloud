package com.github.tnessn.fcloud.b.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "fcloud-b-service" )
public interface BService{
	
	@GetMapping(value="/inner/b/helloB")
    String helloB(@RequestParam String  name);
}