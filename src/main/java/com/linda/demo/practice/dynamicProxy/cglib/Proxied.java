package com.linda.demo.practice.dynamicProxy.cglib;

public class Proxied implements ProxiedInterface{

  public  void execute(){
    System.out.println("execute method in proxied class");
  }

  @Override
  public void run() {
    System.out.println("excute interface method in proxied class");
  }
}
