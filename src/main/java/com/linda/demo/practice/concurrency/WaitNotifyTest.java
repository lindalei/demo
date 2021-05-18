package com.linda.demo.practice.concurrency;

import java.util.concurrent.TimeUnit;

public class WaitNotifyTest {
  private static final Object signal = new Object();
  public static void main(String[] args) {

    Thread thread1 = new Thread(new WaitThread());
    Thread thread2 = new Thread(new WaitThread());
    Thread thread3 = new Thread(new NotifyThread());

    thread1.start();
    thread2.start();
    thread3.start();
  }

  static class WaitThread implements Runnable {
    @Override
    public void run() {
      try {
        TimeUnit.SECONDS.sleep(1);
        synchronized (signal) {
          System.out.println(Thread.currentThread().getName());
          System.out.println("Thread is in Wait ...");
          signal.wait();
        }
        System.out.println("Thread is out Wait ...");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static class NotifyThread implements Runnable {
    @Override
    public void run() {
      try {
        TimeUnit.SECONDS.sleep(5);
        synchronized (signal) {
          System.out.println(Thread.currentThread().getName());
          System.out.println("Start Notify All Wait Thread ...");
          signal.notifyAll();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
