package com.linda.demo.practice;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class EventListener {

  static class EventListener1 {
    @Subscribe
    public void onMessageRevieve(String msg) {
      System.out.println("message revieved!!!".concat(msg));
    }
  }

  static class EventListener2 {

    @Subscribe
    public void onMessage1(String msg) {
      System.out.println("test".concat(msg));
    }
  }

  public static void eventBusConfig() {
    EventBus eventBus = new EventBus();
    eventBus.register(new EventListener1());
    eventBus.post("hello");
  }

  public static void eventBusConfig1() {
    EventBus eventBus1 = new EventBus();
    eventBus1.register(new EventListener2());
    eventBus1.post("hello1111");
  }

  public static void main(String[] args) {
    eventBusConfig();
    eventBusConfig1();
  }
}