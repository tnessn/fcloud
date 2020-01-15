/**
 * 
 */
package com.github.tnessn.fcloud.a.service.impl;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

import com.github.tnessn.fcloud.api.service.a.AService;
import com.github.tnessn.fcloud.api.service.b.BService;

/**
 * @author huangjinfeng
 */
@Service(version = "1.0.0", protocol = { "dubbo"})
public class AServiceImpl implements AService {
	
	@Reference(version = "1.0.0", protocol = "dubbo")
	private BService bService;

	@Override
	public String helloA(String name) {
		return "(A)"+bService.helloB(name);
	}

}
