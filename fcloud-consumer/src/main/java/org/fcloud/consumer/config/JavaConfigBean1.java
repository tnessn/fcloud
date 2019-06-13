package org.fcloud.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/**
 *  
 * @author huangjinfeng
 */
@Configuration
public class JavaConfigBean1 {

	@Value("${timeout:20}")
	private int timeout;

	public int getTimeout() {
		return timeout;
	}
}