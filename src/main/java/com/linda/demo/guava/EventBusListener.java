package com.linda.demo.guava;

import com.google.common.eventbus.Subscribe;

public class EventBusListener {

  @Subscribe
  public static void handle(String message) {
    System.out.println("received message: " + message);
  }

  @Subscribe
  public static void handle1(String message) {
    System.out.println("received message1: " + message);
  }
}
