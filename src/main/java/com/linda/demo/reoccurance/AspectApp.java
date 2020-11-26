package com.linda.demo.reoccurance;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectApp {

  @Pointcut("execution(* com.linda.demo.reoccurance.Index.*(..))")
  public void appPointCut(){
  }

  @Before("appPointCut()")
  public void beforeMethod(){
    System.out.println("-----aop-----");
  }
}
