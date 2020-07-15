package com.linda.demo.practice;

public class Reorder {
  static int a = 0;
  static boolean flag = false;
  public static  void method1() throws InterruptedException {
    a = 1;
    //Thread.currentThread().sleep(1);
    flag = true;
    a++;
  }

  public static  void method2() {
    Thread.yield();
    if (flag) {
      a = a + 5;
    }
  }

  private static class SubThread1 extends Thread {
    @Override
    public void run() {
      try {
        method1();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private static class SubThread2 extends Thread {
    @Override
    public void run() {
      method2();
    }
  }

  public static void main(String[] args) {
    SubThread1 subThread1 = new SubThread1();
    subThread1.start();
    SubThread2 subThread2 = new SubThread2();
    subThread2.start();
    if(subThread1.isAlive() || subThread2.isAlive()){}
    System.out.println(a);
  }
}
