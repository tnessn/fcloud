package com.github.tnessn.fcloud.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class BeanLocator implements ApplicationContextAware {

    public static final String PROD = "prod";
    public static final String TEST = "test";
    public static final String DEV = "dev";

    private static ApplicationContext ctx;     //Spring应用上下文环境

    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     *
     * @param ctx
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        BeanLocator.ctx = ctx;
    }

    /**
     * 获取对象
     *
     * @param name
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException
     */
    @SuppressWarnings("unchecked")
    public static  <T> T  getBean(String name) throws BeansException {
        assertContextInjected();
        return  (T)ctx.getBean(name);
    }
    
    public static  <T> T  getBean(Class<T> classz) throws BeansException {
      assertContextInjected();
      return  (T)ctx.getBean(classz);
  }
    
    public static  <T> T  getBean(String name,Class<T> classz) throws BeansException {
        assertContextInjected();
        return  (T)ctx.getBean(name, classz);
    }

    /**
     * 获取当前环境标识
     *
     * @return
     */
    public static String getActiveProfile() {
        assertContextInjected();
        return ctx.getEnvironment().getActiveProfiles()[0];
    }

    /**
     * 判断是否为dev环境
     *
     * @return
     */
    public static boolean isDevEnv() {
        assertContextInjected();
        return DEV.equals(getActiveProfile());
    }

    /**
     * 判断是否为test环境
     *
     * @return
     */
    public static boolean isTestEnv() {
        assertContextInjected();
        return TEST.equals(getActiveProfile());
    }

    /**
     * 判断是否为prod环境
     *
     * @return
     */
    public static boolean isProdEnv() {
        assertContextInjected();
        return PROD.equals(getActiveProfile());
    }

    /**
     * 检查ApplicationContext不为空.
     */
    private static void assertContextInjected() {
        if (ctx == null) {
            throw new IllegalStateException("Spring application context未注入,请在spring配置文件中定义BeanLocator");
        }
    }
}
