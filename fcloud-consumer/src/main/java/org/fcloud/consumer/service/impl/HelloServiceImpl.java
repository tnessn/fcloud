package org.fcloud.consumer.service.impl;

import org.fcloud.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class HelloServiceImpl implements HelloService {
	 @Autowired
	    private RestTemplate restTemplate;

	    @HystrixCommand(fallbackMethod = "error")
	    @Override
	    public String hello() {
	        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class);
	        return responseEntity.getBody();
	    }

	    public String error() {
	        return "error";
	    }
}
