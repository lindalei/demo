package com.linda.demo.reoccurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Order {
  public Order() {
    System.out.println("constructor: order");
  }

//  @Autowired
//  Index index;
//
//  public void getService() {
//    System.out.println(index);
//  }
}
