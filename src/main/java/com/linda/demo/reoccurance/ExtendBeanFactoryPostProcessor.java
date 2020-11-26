//package com.linda.demo.reoccurance;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.beans.factory.support.GenericBeanDefinition;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ExtendBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
//  @Override
//  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
//      throws BeansException {
//    GenericBeanDefinition beanDefinition=
//        (GenericBeanDefinition) beanFactory.getBeanDefinition("index");
//    beanDefinition.setBeanClass(Order.class);
//  }
//}
