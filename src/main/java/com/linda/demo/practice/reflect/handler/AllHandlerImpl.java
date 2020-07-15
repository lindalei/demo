package com.linda.demo.practice.reflect.handler;

import com.linda.demo.practice.reflect.cmd.DriveCmd;
import com.linda.demo.practice.reflect.cmd.RideCmd;

public class AllHandlerImpl implements RideHandler, DriveHandler {
  @Override
  public void handle(DriveCmd cmd) {
    System.out.println("handle drive cmd");
  }

  @Override
  public void handle(RideCmd cmd) {
    System.out.println("handle ride cmd");
  }
}
