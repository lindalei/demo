package com.linda.demo.reoccurance;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/*
不加@Component注解，则spring不会执行AOP逻辑，需要将类手动注入，Im'portBeanDefinitionRegistrar
 */
//@Component
public class IndexPostProcessor implements BeanPostProcessor {
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    if(beanName.equals("index")){
      System.out.println("index before initialization");
      return bean;
    }

    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if(beanName.equals("index")){
      System.out.println("index after initialization");
      Class[] classes= new Class[]{CommonInterface.class};
      return Proxy.newProxyInstance(IndexPostProcessor.class.getClassLoader(),classes,new IndexInvocation(bean));
    }
    return bean;
  }
}
