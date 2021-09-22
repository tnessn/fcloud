/**
 * 
 */
package com.github.tnessn.fcloud.b.service.controller;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.tnessn.fcloud.a.api.AService;
import com.github.tnessn.fcloud.common.util.BeanLocator;

/**
 * @author huangjinfeng
 */
@RestController
public class HelloController {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	//@DubboReference(version = "1.0.0")
	@Autowired
	private AService aService;
	
	@GetMapping("/hello")
	public String hello(@RequestParam String name) {
		LOG.error("bbbbbbb={}",BeanLocator.getBean(AService.class).hashCode());
		return aService.helloA(name);
	}

}
