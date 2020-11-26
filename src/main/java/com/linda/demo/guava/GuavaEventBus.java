package com.linda.demo.guava;

import com.google.common.eventbus.EventBus;

public class GuavaEventBus {
  static EventBus eventBus = new EventBus();

  public static void register(Object observer) {
    eventBus.register(observer);
  }

  public static void post(Object message) {
    eventBus.post(message);
  }
}
