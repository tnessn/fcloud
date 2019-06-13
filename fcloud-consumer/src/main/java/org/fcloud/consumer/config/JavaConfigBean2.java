package org.fcloud.consumer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 此种方式发布不会自动刷新
 * @author huangjinfeng
 */
@Configuration
@ConfigurationProperties(prefix = "xx")
public class JavaConfigBean2 {

	private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}