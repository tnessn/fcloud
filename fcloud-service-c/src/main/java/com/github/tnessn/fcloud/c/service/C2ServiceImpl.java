/**
 * 
 */
package com.github.tnessn.fcloud.c.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import com.github.tnessn.fcloud.api.service.c.C2Service;

/**
 * @author huangjinfeng
 */
@DubboService(version = "1.0.0", protocol = { "dubbo"})
@Service
public class C2ServiceImpl implements C2Service {

	@Override
	public String helloC2(String name) {
		return name+"(c)";
	}

}
