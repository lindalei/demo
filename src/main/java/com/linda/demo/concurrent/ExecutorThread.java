package com.linda.demo.concurrent;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorThread {

    public static void main(String[] args){
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i <100 ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

    }


}
