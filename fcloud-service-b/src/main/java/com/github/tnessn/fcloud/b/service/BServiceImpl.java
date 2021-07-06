/**
 * 
 */
package com.github.tnessn.fcloud.b.service;


import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;

import com.github.tnessn.fcloud.api.service.b.BService;
import com.github.tnessn.fcloud.api.service.c.CService;

/**
 * @author huangjinfeng
 */
@DubboService(version = "1.0.0", protocol = { "dubbo"})
public class BServiceImpl implements BService {
	
	@DubboReference(version = "1.0.0", protocol = "dubbo")
	private CService cService;

	@Override
	public String helloB(String name) {
		return "(b)"+cService.helloC(name);
	}

}
