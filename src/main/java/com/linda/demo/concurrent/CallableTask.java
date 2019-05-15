package com.linda.demo.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("正在计算..");
        Thread.sleep(1000);
        return 1;
    }
    public static void main(String[] args) throws Exception{
        FutureTask<Integer> task=new FutureTask<>(new CallableTask());
        Thread t= new Thread(task);

        t.start();

        Integer result =task.get();//会阻塞
        System.out.println(result);
        System.out.println("先干点别的");

     }
}
