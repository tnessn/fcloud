/**
 * 
 */
package com.github.tnessn.fcloud.a.service.impl;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

import com.github.tnessn.fcloud.a.api.AService;
import com.github.tnessn.fcloud.a.service.config.JavaConfigBean1;
import com.github.tnessn.fcloud.a.service.config.JavaConfigBean2;
import com.github.tnessn.fcloud.common.util.BeanLocator;

/**
 * @author huangjinfeng
 */
@RestController("aService")
@RefreshScope
public class AServiceImpl implements AService {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Value("${ab}")
	private String ab;
	@Autowired
	private JavaConfigBean1 javaConfigBean1;
	@Autowired
	private JavaConfigBean2 javaConfigBean2;


	@Override
	public String helloA(String name) {
		LOG.error("aaaaaaaaaaaa={}",BeanLocator.getBean(AService.class).hashCode());
		return ab+"|"+javaConfigBean1.getTimeout()+"|"+javaConfigBean2.getName();
	}
	
}
