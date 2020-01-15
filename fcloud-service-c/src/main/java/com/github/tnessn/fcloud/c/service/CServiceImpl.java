/**
 * 
 */
package com.github.tnessn.fcloud.c.service;

import org.apache.dubbo.config.annotation.Service;

import com.github.tnessn.fcloud.api.service.c.CService;

/**
 * @author huangjinfeng
 */
@Service(version = "1.0.0", protocol = { "dubbo"})
public class CServiceImpl implements CService {

	@Override
	public String helloC(String name) {
		return name+"(c)";
	}

}
