package com.linda.demo.practice;

import sun.net.spi.nameservice.dns.DNSNameService;

import java.util.concurrent.ConcurrentHashMap;

public class VolatileAtomicTest {
  private static volatile int count;
  public static final int NUMBER = 10000;

  public static void main(String[] args) throws InterruptedException {
    System.out.println(VolatileAtomicTest.class.getClassLoader());
    System.out.println(String.class.getClassLoader());
    System.out.println(ConcurrentHashMap.class.getClassLoader());
    System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
    SubThread subThread = new SubThread();
    subThread.start();
//    SubThread subThread1 = new SubThread();
//    subThread1.start();
    for (int i = 0; i < NUMBER; i++) {
      count++;
      //Thread.currentThread().sleep(100);
    }

//    while (subThread.isAlive() || subThread1.isAlive()) {
//    }
    while (subThread.isAlive() ) {
    }
    Thread.sleep(3000);

    System.out.println(count);
  }

  private static class SubThread extends Thread {
    @Override
    public void run() {
      for (int i = 0; i < NUMBER; i++) {
        count--;
      }
    }
  }

  private static class SubThread1 extends Thread {
    @Override
    public void run() {
      for (int i = 0; i < NUMBER; i++) {
        count++;
      }
    }
  }
}
