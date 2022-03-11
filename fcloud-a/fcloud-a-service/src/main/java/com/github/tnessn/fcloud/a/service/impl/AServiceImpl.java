/**
 * 
 */
package com.github.tnessn.fcloud.a.service.impl;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.github.tnessn.fcloud.a.api.AService;
import com.github.tnessn.fcloud.b.api.BService;
import com.github.tnessn.fcloud.common.util.HttpRequestUtils;

/**
 * @author huangjinfeng
 */
@RestController("aService")
public class AServiceImpl implements AService {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired
	private BService bService;


	@Override
	public String helloA(String name) {
		LOG.error("AServiceImpl.helloA  start");
		LOG.error("vvvvvvvvvvvvv:{}",HttpRequestUtils.getHttpServletRequest().getHeader("test"));
		bService.helloB(name);
		LOG.error("AServiceImpl.helloA  end");
		return "AServiceImpl.helloA";
	}
	
}
