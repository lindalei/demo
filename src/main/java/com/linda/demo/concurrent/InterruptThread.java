package com.linda.demo.concurrent;

public class InterruptThread extends Thread {
    InterruptThread(String name){
        super(name);
    }
    InterruptThread(){
        super();
    }

    @Override
    public void run() {
        while(!interrupted()){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+"执行");
        }
    }
    public static void main(String[] args){
        InterruptThread t1= new InterruptThread("线程1");
        InterruptThread t2= new InterruptThread("线程2");
        InterruptThread t3= new InterruptThread();
        t3.start();

        t1.start();
        t2.start();
        t1.interrupt();
        t2.interrupt();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parent");
            }
        }){
            @Override
            public void run() {
                System.out.println("sub"); //只执行sub
            }
        }.start();
    }
}
