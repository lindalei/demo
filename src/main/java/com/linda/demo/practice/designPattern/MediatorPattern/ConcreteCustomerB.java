package com.linda.demo.practice.designPattern.MediatorPattern;

public class ConcreteCustomerB extends Customer {
  @Override
  public void getAssigned() {
    super.getAssigned();
    System.out.println("concrete customer B");
  }
}
