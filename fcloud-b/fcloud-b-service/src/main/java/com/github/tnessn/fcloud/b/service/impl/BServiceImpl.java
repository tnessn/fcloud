/**
 * 
 */
package com.github.tnessn.fcloud.b.service.impl;


import org.apache.dubbo.config.annotation.DubboService;

import com.github.tnessn.fcloud.b.api.BService;

/**
 * @author huangjinfeng
 */
@DubboService(version = "1.0.0", protocol = { "dubbo"})
public class BServiceImpl implements BService {
	

	@Override
	public String helloB(String name) {
		return "b";
	}

}
