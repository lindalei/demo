package com.linda.demo.practice.designPattern.ProxyPattern;

public class ProxyDesign {
  private Customer customer;

  public void setCustomer(Customer customer){
    this.customer=customer;
  }

  public void BuyTea() {
    customer.buyTea();
    queueUp();
    takeAway();
  }

  private void queueUp() {
    System.out.println("start to queue up");
  }

  private void takeAway() {
    System.out.println("tea ready, take out");
  }
}
