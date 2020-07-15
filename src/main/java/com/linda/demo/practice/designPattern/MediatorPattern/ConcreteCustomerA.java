package com.linda.demo.practice.designPattern.MediatorPattern;

public class ConcreteCustomerA extends Customer {
  @Override
  public void getAssigned() {
    super.getAssigned();
    System.out.println("concrete customer");
  }
}
