package com.linda.demo.guava;

public class EventBusTester {

  public static void main(String[] args) {
    GuavaEventBus.register(new EventBusListener());
    GuavaEventBus.post("hello");
  }
}
