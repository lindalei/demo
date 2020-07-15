package com.linda.demo.practice.reflect.handler;

import com.linda.demo.practice.reflect.cmd.Cmd;

public interface Handler {
  default void handle(Cmd cmd){
    System.out.println("default cmd");
  };
}
