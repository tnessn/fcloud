/**
 * 
 */
package com.github.tnessn.fcloud.b.service;


import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

import com.github.tnessn.fcloud.api.service.b.BService;
import com.github.tnessn.fcloud.api.service.c.CService;

/**
 * @author huangjinfeng
 */
@Service(version = "1.0.0", protocol = { "dubbo"})
public class BServiceImpl implements BService {
	
	@Reference(version = "1.0.0", protocol = "dubbo")
	private CService cService;

	@Override
	public String helloB(String name) {
		return "(b)"+cService.helloC(name);
	}

}
