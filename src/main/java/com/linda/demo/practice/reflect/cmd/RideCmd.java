package com.linda.demo.practice.reflect.cmd;

public class RideCmd implements Cmd {
  @Override
  public void execute() {
    System.out.println("ride");
  }
}
