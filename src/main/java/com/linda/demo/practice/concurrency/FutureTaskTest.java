package com.linda.demo.practice.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
  public static void main(String[] args) {
//    int[] a={1,2};
//    for (int i;a!=null;){
//      System.out.println(i);
//    }
    Task task = new Task();
    FutureTask<Integer> futureTask = new FutureTask<Integer>(task) {
      @Override
      protected void done() {
        try {
          System.out.println("feature.done():" + get());
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (ExecutionException e) {
          e.printStackTrace();
        }
      }
    };

//    ExecutorService executor = Executors.newCachedThreadPool();
//    executor.execute(futureTask);
    futureTask.run();

    Thread.currentThread().setName("main thread");
    try {
      futureTask.get();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

    //    try {
    //      Integer result = futureTask.get();
    //      System.out.println("feature.get():" + result);
    //    } catch (InterruptedException e) {
    //      e.printStackTrace();
    //    } catch (ExecutionException e) {
    //      e.printStackTrace();
    //    }

//      futureTask.cancel(false);
//      System.out.println(futureTask.isCancelled());
//      System.out.println(futureTask.isDone());

  }

  static class Task implements Callable<Integer> {
    @Override
    public Integer call() {
      int i = 0;
      for (; i < 10; i++) {
        System.out.println(Thread.currentThread().getName() + "_" + i);
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      return i;
    }
  }
}
