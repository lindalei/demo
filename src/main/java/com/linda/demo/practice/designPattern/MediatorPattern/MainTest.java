package com.linda.demo.practice.designPattern.MediatorPattern;

public class MainTest {


  public static void main(String[] args) {
    Customer a= new ConcreteCustomerA();
    Customer b= new ConcreteCustomerB();
    Mediator m= new ConcreteMediator();
    m.setCustomer(a);
    m.assign();
    m.setCustomer(b);
    m.assign();
  }
}
