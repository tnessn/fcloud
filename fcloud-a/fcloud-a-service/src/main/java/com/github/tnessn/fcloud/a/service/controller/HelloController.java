/**
 * 
 */
package com.github.tnessn.fcloud.a.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangjinfeng
 */
@RestController
public class HelloController {
	
	
	@GetMapping("/hello")
	public String hello(@RequestParam String name) {
		return "123";
	}

}
