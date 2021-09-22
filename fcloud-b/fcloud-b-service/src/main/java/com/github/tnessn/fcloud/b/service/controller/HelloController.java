/**
 * 
 */
package com.github.tnessn.fcloud.b.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.tnessn.fcloud.a.api.AService;

/**
 * @author huangjinfeng
 */
@RestController
public class HelloController {
	
	//@DubboReference(version = "1.0.0")
	@Autowired
	private AService aService;
	
	@GetMapping("/hello")
	public String hello(@RequestParam String name) {
		return aService.helloA(name);
	}

}
