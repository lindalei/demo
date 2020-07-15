package com.linda.demo.practice.reflect.handler;

import com.linda.demo.practice.reflect.cmd.RideCmd;

public interface RideHandler extends Handler {
  void handle(RideCmd cmd);
}
