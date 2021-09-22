/**
 * 
 */
package com.github.tnessn.fcloud.a.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.github.tnessn.fcloud.a.api.AService;

/**
 * @author huangjinfeng
 */
@Service(value="aService")
@RestController
public class AServiceImpl implements AService {


	@Override
	public String helloA(String name) {
		return "(A)";
	}
	
}
