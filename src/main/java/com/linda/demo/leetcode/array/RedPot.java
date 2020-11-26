package com.linda.demo.leetcode.array;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class RedPot {
  private static final int num = 5;
  private static final int amount = 200;
  private static int result = 0;

  public static void seize() {

  }

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch countDownLatch = new CountDownLatch(num);
    for (int i = 0; i < num; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          int value = new Random().nextInt(amount);
          if (value < 0.01) {
            try {
              throw new Exception("太少");
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
          result += value;
          countDownLatch.countDown();
        }
      });
    }
    countDownLatch.await();
    System.out.println("抢红包结束");
  }
}
