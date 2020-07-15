package com.linda.demo.practice.reflect;

import com.linda.demo.practice.reflect.cmd.Cmd;
import com.linda.demo.practice.reflect.cmd.DriveCmd;
import com.linda.demo.practice.reflect.cmd.RideCmd;
import com.linda.demo.practice.reflect.handler.Handler;

import java.lang.reflect.Proxy;

public class MainTest {
  public static void main(String[] args) {
    Cmd driveCmd = new DriveCmd();
    Cmd rideCmd = new RideCmd();
    Handler handler = (Handler) Proxy
        .newProxyInstance(Handler.class.getClassLoader(), new Class[]{Handler.class},
            new HandlerInvocationHandler());
    handler.handle(driveCmd); //根据不同的参数调用不同的方法，反射
    handler.handle(rideCmd);
  }
}
