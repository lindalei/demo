package com.linda.demo.reoccurance;

import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

public class Test {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    /*
    此处修改不生效，要实现BeanFactoryPostProcessor接口方法，在里面更改，因为spring生成bean的步骤为
    1. scan
    2. parse: 解析bean定义，生成BeanDefinition
    3. 扩展：
    4. 遍历map, validate prototype, prototype的只有在getBean时才会new
    5. new
     */

    //    GenericBeanDefinition beanDefinition= (GenericBeanDefinition) ac.getBeanDefinition
    //    ("index");
    //    beanDefinition.setBeanClass(Order.class);
    //ac.getBean("index");
    //    Index index = (Index) ac.getBean("index");
    //    index.getService();
    ac.getBean(CommonInterface.class).interfaceMethod();
  }
}
