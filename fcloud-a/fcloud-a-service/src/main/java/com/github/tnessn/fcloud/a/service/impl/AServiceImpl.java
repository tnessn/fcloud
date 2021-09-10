/**
 * 
 */
package com.github.tnessn.fcloud.a.service.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;

import com.github.tnessn.fcloud.a.api.AService;
import com.github.tnessn.fcloud.b.api.BService;

/**
 * @author huangjinfeng
 */
@DubboService(version = "1.0.0")
public class AServiceImpl implements AService {
	
	@DubboReference(version = "1.0.0")
	private BService bService;

	@Override
	public String helloA(String name) {
		return "(A)";
	}
	
}
