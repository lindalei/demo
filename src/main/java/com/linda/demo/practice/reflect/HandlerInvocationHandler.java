package com.linda.demo.practice.reflect;

import com.linda.demo.practice.reflect.handler.AllHandlerImpl;
import com.linda.demo.practice.reflect.handler.Handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HandlerInvocationHandler implements InvocationHandler {
  Handler handler = new AllHandlerImpl();

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    Method targetMethod = handler.getClass().getMethod("handle", args[0].getClass());
    return targetMethod.invoke(handler, args);
  }
}
