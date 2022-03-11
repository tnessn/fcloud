/**
 * 
 */
package com.github.tnessn.fcloud.b.service.impl;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import com.github.tnessn.fcloud.b.api.BService;
import com.github.tnessn.fcloud.common.util.HttpRequestUtils;

/**
 * @author huangjinfeng
 */
@RestController("bService")
public class BServiceImpl implements BService {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


	@Override
	public String helloB(String name) {
		LOG.error("BServiceImpl.helloB  start");
		LOG.error("vvvvvvvvvvvvv:{}",HttpRequestUtils.getHttpServletRequest().getHeader("test"));
		LOG.error("BServiceImpl.helloB  end");
		return "BServiceImpl.helloB";
	}
	
}
