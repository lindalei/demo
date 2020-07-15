package com.linda.demo.practice;

public class ThreadTest extends Thread {
  @Override
  public void run() {
    if (Thread.currentThread().isInterrupted()) {
      System.out.println("interrupted");
    } else {
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("not interrupted");
    }
  }


  public static void main(String[] args)  {
    ThreadTest test = new ThreadTest();
    test.start();

    test.interrupt();
  }
}
