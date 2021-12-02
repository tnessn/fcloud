package com.github.tnessn.fcloud.a.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;


/**
 *  此种方式发布会自动刷新
 * @author huangjinfeng
 */
@Configuration
@RefreshScope
public class JavaConfigBean1 {

	@Value("${timeout:20}")
	private int timeout;

	public int getTimeout() {
		return timeout;
	}
}