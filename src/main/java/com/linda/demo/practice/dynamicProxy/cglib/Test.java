package com.linda.demo.practice.dynamicProxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class Test {
  public static void main(String[] args) {
    MyMethodInterceptor myMethodInterceptor = new MyMethodInterceptor();

    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(Proxied.class);
    enhancer.setCallback(myMethodInterceptor);
    //可以执行特定类中的方法，而不只是接口中的
    Proxied o = (Proxied) enhancer.create();
    o.execute();

    o.run();
  }
}
