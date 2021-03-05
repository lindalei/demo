package com.linda.demo.practice.dynamicProxy.invocationHandler;

import java.lang.reflect.Proxy;

public class Test {
  public static void main(String[] args) {
    JDKProxiedInterface jdkProxied = new JDKProxied();
    MyInvocationHandler myInvocationHandler = new MyInvocationHandler(jdkProxied);
    //注意第二个参数需要是实例获取的interfaces[], 而不是接口（JDKProxiedInterface.class.getInterfaces()）
    JDKProxiedInterface proxy = (JDKProxiedInterface) Proxy
        .newProxyInstance(JDKProxiedInterface.class.getClassLoader(),
            jdkProxied.getClass().getInterfaces(), myInvocationHandler);
    //只能调用接口中的方法
    proxy.run();
  }
}
