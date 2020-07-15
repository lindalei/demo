package com.linda.demo.practice.reflect.cmd;

public class DriveCmd implements Cmd {
  @Override
  public void execute() {
    System.out.println("drive");
  }
}
