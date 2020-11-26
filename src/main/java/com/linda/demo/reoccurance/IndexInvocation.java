package com.linda.demo.reoccurance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class IndexInvocation implements InvocationHandler {
  Object o;

  public IndexInvocation(Object o) {
    this.o = o;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("--------aop-----------");
    return method.invoke(o, args);
  }
}
