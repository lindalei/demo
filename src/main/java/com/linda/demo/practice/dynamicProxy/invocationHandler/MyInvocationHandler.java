package com.linda.demo.practice.dynamicProxy.invocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
  JDKProxiedInterface jdkProxied;

  public MyInvocationHandler(JDKProxiedInterface jdkProxied) {
    this.jdkProxied = jdkProxied;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("before");
    method.invoke(jdkProxied, args);
    System.out.println("after");
    return null;
  }
}
