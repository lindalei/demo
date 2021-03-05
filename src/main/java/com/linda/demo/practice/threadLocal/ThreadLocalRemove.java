package com.linda.demo.practice.threadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalRemove {
  static AtomicInteger value = new AtomicInteger(12);
  static ThreadLocal<Integer> value2= ThreadLocal.withInitial(()->new Integer(10));
  static Integer value1= 50;

  static ThreadLocal<AtomicInteger> threadLocal =
      ThreadLocal.withInitial(() -> new AtomicInteger(10));

  static class Task implements Runnable {
    @Override
    public void run() {
      //      int i = threadLocal.get().getAndIncrement();
      //      System.out.println(i);
      //threadLocal.remove();
      //ThreadLocal<Integer> localValue = new ThreadLocal<>();
     // localValue.set(value1);
      System.out.println(Thread.currentThread().getName());

      value2.set(value2.get()+1);
      System.out.println(value2.get());
      value2.remove();
    }
  }

  public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Task());
        executorService.submit(new Task());
        executorService.submit(new Task());
    //new Thread(new Task()).start();
//    new Thread(new Task()).start();
//    new Thread(new Task()).start();
  }
}
