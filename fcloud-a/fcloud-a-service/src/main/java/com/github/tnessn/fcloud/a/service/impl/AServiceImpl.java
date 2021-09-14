/**
 * 
 */
package com.github.tnessn.fcloud.a.service.impl;

import org.apache.dubbo.config.annotation.DubboService;

import com.github.tnessn.fcloud.a.api.AService;

/**
 * @author huangjinfeng
 */
@DubboService(version = "1.0.0")
public class AServiceImpl implements AService {


	@Override
	public String helloA(String name) {
		return "(A)";
	}
	
}
