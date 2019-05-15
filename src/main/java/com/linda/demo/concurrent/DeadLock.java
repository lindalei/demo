package com.linda.demo.concurrent;

public class DeadLock {
    DeadLock obj1 = new DeadLock();
    DeadLock obj2 = new DeadLock();

    public void a() {
        synchronized (obj1) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2) {
                System.out.println("a");

            }
        }


    }

    public void b() {
        synchronized (obj2) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj1) {
                System.out.println("b");
            }
        }


    }

    public static void main(String[] args) {
        System.out.println("hello");
        DeadLock deadLock= new DeadLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.a();

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.b();
            }
        }).start();
    }
}
