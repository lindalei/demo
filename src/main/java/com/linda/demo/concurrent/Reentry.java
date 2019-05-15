package com.linda.demo.concurrent;

import javax.swing.*;

public class Reentry {
    public  synchronized void a(){
        System.out.println(Thread.currentThread().getName()+" a");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b();
    }
    public  synchronized void b(){
        System.out.println(Thread.currentThread().getName()+" b");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        System.out.println("hello");
        Reentry r1= new Reentry();
        Reentry r2= new Reentry();

        new Thread(new Runnable() {
            @Override
            public void run() {
                r1.a(); //执行完后释放了锁资源，可能另一个线程获得锁资源先执行，于是下面的语句随后再输出
                System.out.println("call a method");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                r1.b();
            }
        }).start();
    }
}
