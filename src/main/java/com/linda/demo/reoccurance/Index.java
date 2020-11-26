package com.linda.demo.reoccurance;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Index implements InitializingBean, CommonInterface {
  public Index() {
    System.out.println("constructor: index");
  }

  @Autowired
  Order order;

  public void getService() {
    System.out.println("get service");
  }

  /*
   初始化生命周期的回调方法
   */
  @PostConstruct
  public void postMethod() {
    System.out.println("post constructor");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("after propertySet");
  }

  @Override
  public void interfaceMethod() {
    System.out.println("index implement interface");
  }
}
