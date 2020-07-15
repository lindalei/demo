package com.linda.demo.practice.designPattern.MediatorPattern;

public abstract class Mediator {
  Customer customer;

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public void assign() {
    System.out.println("do things for customer: " + customer.toString());
  }
}
