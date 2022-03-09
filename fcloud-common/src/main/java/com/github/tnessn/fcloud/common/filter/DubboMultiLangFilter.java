package com.github.tnessn.fcloud.common.filter;

import java.lang.invoke.MethodHandles;


import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.tnessn.fcloud.common.util.I18NUtils;
import com.github.tnessn.fcloud.common.util.MyThreadContext;


@Activate(group = {CommonConstants.CONSUMER, CommonConstants.PROVIDER})
public class DubboMultiLangFilter implements Filter {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
    	LOG.error("---------->isConsumer:{}",RpcContext.getContext().isConsumerSide());
       //判断是消费者  还是 服务提供者
        if (RpcContext.getContext().isConsumerSide()) {
            RpcContext.getContext().setAttachment(I18NUtils.LANG_PARAM, MyThreadContext.getLang());
        } else {
            String lang =RpcContext.getContext().getAttachment(I18NUtils.LANG_PARAM);
            MyThreadContext.setLang(lang);
        }
            return invoker.invoke(invocation);
    }
}
