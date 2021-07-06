/**
 * 
 */
package com.github.tnessn.fcloud.a.service.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;

import com.github.tnessn.fcloud.api.service.a.AService;
import com.github.tnessn.fcloud.api.service.b.BService;

/**
 * @author huangjinfeng
 */
@DubboService(version = "1.0.0", protocol = { "dubbo"})
public class AServiceImpl implements AService {
	
	@DubboReference(version = "1.0.0", protocol = "dubbo")
	private BService bService;

	@Override
	public String helloA(String name) {
		return "(A)"+bService.helloB(name);
	}
	
}
