package com.linda.demo.practice.designPattern.StrategyPattern;

public class Person {
  private Strategy strategy;
  private static Person person;

  static {
    person = new Person();
  }

  public static Person getPerson() {
    return person;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public void goWork() {
    System.out.println("go to work:");
    strategy.commute();
  }
}
