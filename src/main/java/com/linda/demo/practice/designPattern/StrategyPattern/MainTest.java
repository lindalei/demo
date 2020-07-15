package com.linda.demo.practice.designPattern.StrategyPattern;

public class MainTest {
  public static void main(String[] args) {
    Person person = Person.getPerson();
    person.setStrategy(new BikeStrategy());
    person.goWork();
  }
}
