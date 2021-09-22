package com.github.tnessn.fcloud.common.config;

import java.lang.invoke.MethodHandles;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSON;
import com.github.tnessn.fcloud.common.enums.ErrorCodeEnum;
import com.github.tnessn.fcloud.common.exceptions.BizException;
import com.github.tnessn.fcloud.common.util.RespData;

import feign.Response;
import feign.Util;

/**
 * @author huangjinfeng
 */
@Configuration
@ConditionalOnClass(value= feign.codec.ErrorDecoder.class)
public class FeignClientErrorDecoder implements feign.codec.ErrorDecoder {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public Exception decode(String methodKey, Response response) {
    	LOG.error("vvvvvvvvvvvv={}",response.request().url());
        if (/*response.status() == HttpStatus.FORBIDDEN.value() ||*/ response.status() >= 400 && response.status() <= 500) {
            String errorContent;
            try {
                errorContent = Util.toString(response.body().asReader());
                RespData<?> resultData = JSON.parseObject(errorContent, RespData.class);
                return new BizException(resultData.getCode(), resultData.getMsg());
            } catch (Exception e) {
                LOG.error(null, e);
                return new BizException(ErrorCodeEnum.DEFAULT.getCode(), "unknown error");
            }
        }
        return new BizException(ErrorCodeEnum.DEFAULT.getCode(), "unknown error");
    }
}