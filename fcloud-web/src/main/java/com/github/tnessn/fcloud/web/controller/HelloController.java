/**
 * 
 */
package com.github.tnessn.fcloud.web.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.tnessn.fcloud.api.service.a.AService;

/**
 * @author huangjinfeng
 */
@RestController
public class HelloController {
	
	@Reference(version = "1.0.0", protocol = "dubbo")
	private AService aService;
	
	@GetMapping("/hello")
	public String hello(@RequestParam String name) {
		return aService.helloA(name);
	}

}
