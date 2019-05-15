package com.linda.demo.concurrent;

public class WaitNotify {
    private int signal;

    public synchronized int getSignal() {
        while(signal!=1){
            try {
                System.out.println(Thread.currentThread().getName()+"开始等待...");
                wait(); //等待过程会释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"执行完毕...");
        return signal;
    }

    public synchronized void setSignal() {
        this.signal = 1;
        notifyAll();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"通知结束");
    }

    public static void main(String[] args){
        WaitNotify waitNotify=new WaitNotify();
        Thread1 thread1= new Thread1(waitNotify);
        Thread2 thread2= new Thread2(waitNotify);
       new Thread(thread2).start();
        new Thread(thread2).start();
        new Thread(thread2).start();
        new Thread(thread2).start();
        new Thread(thread1).start();
    }
}
