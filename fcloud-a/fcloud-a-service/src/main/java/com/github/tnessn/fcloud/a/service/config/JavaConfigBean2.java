package com.github.tnessn.fcloud.a.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * 此种方式发布不会自动刷新
 * @author huangjinfeng
 */
@Configuration
@RefreshScope
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