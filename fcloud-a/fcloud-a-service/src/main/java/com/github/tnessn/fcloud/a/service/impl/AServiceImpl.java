/**
 * 
 */
package com.github.tnessn.fcloud.a.service.impl;

import org.springframework.web.bind.annotation.RestController;

import com.github.tnessn.fcloud.a.api.AService;

/**
 * @author huangjinfeng
 */
@RestController
public class AServiceImpl implements AService {


	@Override
	public String helloA(String name) {
		if(1==1) {
			throw new RuntimeException();
		}
		return "(A)";
	}
	
}
