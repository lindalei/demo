package com.linda.demo.practice.designPattern.StrategyPattern;

public class CarStrategy implements Strategy {
  @Override
  public void commute() {
    System.out.println("go to work by car");
  }
}
