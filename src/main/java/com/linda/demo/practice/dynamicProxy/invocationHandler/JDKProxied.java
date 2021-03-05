package com.linda.demo.practice.dynamicProxy.invocationHandler;

public class JDKProxied implements JDKProxiedInterface {
  @Override
  public void run() {
    System.out.println("execute method in JDK proxied class");
  }

  public void execute(){
    System.out.println("execute interface method in JDK proxied class");
  }
}
