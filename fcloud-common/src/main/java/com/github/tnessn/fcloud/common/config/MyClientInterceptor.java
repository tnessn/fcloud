package com.github.tnessn.fcloud.common.config;

import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;

//拦截器实现
@Configuration
class MyClientInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("test","huangjinfeng");
    }
    
}