package com.linda.demo.practice.designPattern.ProxyPattern;

public class MainTest {
  public static void main(String[] args) {
    Customer linda=new Customer();
    ProxyDesign proxyDesign= new ProxyDesign();
    proxyDesign.setCustomer(linda);
    proxyDesign.BuyTea();

  }
}
