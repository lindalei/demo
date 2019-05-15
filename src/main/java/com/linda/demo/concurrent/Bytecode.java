package com.linda.demo.concurrent;

public class Bytecode {
    private static int value;

    public static int getNext() {
        return value++;
    }

    public static void main(String[] args) {
        Bytecode bytecode = new Bytecode();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + Bytecode.getNext());

                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + Bytecode.getNext());
                }

            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + Bytecode.getNext());
                }
            }
        }).start();
    }
}
