/**
 * 
 */
package com.github.tnessn.fcloud.a.service.impl;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import com.github.tnessn.fcloud.a.api.AService;
import com.github.tnessn.fcloud.common.enums.ErrorCodeEnum;
import com.github.tnessn.fcloud.common.exceptions.BizException;
import com.github.tnessn.fcloud.common.util.BeanLocator;

/**
 * @author huangjinfeng
 */
@RestController("aService")
public class AServiceImpl implements AService {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


	@Override
	public String helloA(String name) {
		throw new BizException(ErrorCodeEnum.NOT_LOGGED_IN);
	}
	
}
