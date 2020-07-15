package com.linda.demo.practice.designPattern.FacadePattern;

import com.linda.demo.practice.designPattern.ProxyPattern.Customer;

public class MainTest {
  public static void main(String[] args) {
    Facade facade = new Facade();
    Customer linda = new Customer();
    facade.service(linda);
  }
}
