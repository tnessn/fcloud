package org.fcloud.consumer.controller;

import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import org.fcloud.consumer.config.JavaConfigBean1;
import org.fcloud.consumer.config.JavaConfigBean2;
import org.fcloud.consumer.config.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;

@RestController
public class ApolloController {
  
  @Resource
  private JavaConfigBean1 javaConfigBean1;
  @Resource
  private JavaConfigBean2 javaConfigBean2;
  
  @ApolloConfig
  private Config config;
  
//4. @ApolloJsonValue使用
@ApolloJsonValue("${jsonBeanProperty:[]}")
private List<User> anotherJsonBeans;


  /**
   * 此种方式发布会自动刷新
   * @return
   */
  @RequestMapping(value = "/test")
  public int test() {
    return javaConfigBean1.getTimeout();
  }
  
  
  /**
   * 此种方式发布不会自动刷新
   * @return
   */
  @RequestMapping(value = "/test2")
  public String test2() {
    return javaConfigBean2.getName();
  }
  
  

  /**
   * 此种方式发布会自动刷新
   * @return
   */
 @RequestMapping("/test3")
 public String test3(){
   Set <String> propertyNames = config.getPropertyNames();
   propertyNames.forEach(key -> {
     System.err.println(key+"="+config.getIntProperty(key,0));
   });
   return propertyNames.toString();
 }
 
 @ApolloConfigChangeListener
 private void someOnChange(ConfigChangeEvent changeEvent) {
   //update injected value of batch if it is changed in Apollo
   if (changeEvent.isChanged("timeout")) {
     System.out.println(config.getIntProperty("timeout", 0));
   }
 }
 
 

/**
 * 此种方式发布会自动刷新
 * jsonBeanProperty=[ { "username": "john", "password": "1234" }, { "username": "simon", "password": "222132" } ]
 */
@RequestMapping("/test4")
public void test4(){
 anotherJsonBeans.forEach(item -> {
   System.err.println(item.getUsername()+"--"+item.getPassword());
 });
}
  
}
