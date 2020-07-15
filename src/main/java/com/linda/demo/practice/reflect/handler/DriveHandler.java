package com.linda.demo.practice.reflect.handler;

import com.linda.demo.practice.reflect.cmd.DriveCmd;

public interface DriveHandler extends Handler {
  void handle(DriveCmd cmd);
}
