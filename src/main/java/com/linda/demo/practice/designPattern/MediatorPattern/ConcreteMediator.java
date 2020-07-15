package com.linda.demo.practice.designPattern.MediatorPattern;

public class ConcreteMediator extends Mediator {
  @Override
  public void assign() {
    super.assign();
    System.out.println("do concrete things for customer: " + customer.toString());
  }
}
