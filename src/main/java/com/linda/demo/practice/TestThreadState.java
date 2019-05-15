package com.linda.demo.practice;

import java.util.Scanner;

public class TestThreadState {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.setThread2(t2);

        t1.start();
        t2.start();
        t1.interrupt();
    }
}

//Thread1负责打印所有线程的状态。
class Thread1 extends Thread {
    private Thread2 t2;

    public void setThread2(Thread2 t2) {
        this.t2 = t2;
    }

    @Override
    public void run() {
        System.out.println("进入t1线程");
        for (int i = 0; i < 6; i++) {
            try {
                System.out.println("t1 的状态： " + getState());
                System.out.println("t2 的状态： " + t2.getState());
                System.out.println();


                //为了减少打印次数，所以t1每打印一次睡1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
        System.out.println("进入t1线程结束");
    }
}

  class Thread2 extends Thread {
    @Override
    public void run() {
        System.out.println("进入t2线程");

        //让线程进入I/O
        System.out.println("请输入数据：");
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();
        System.out.println("您输入的数据为：" + read);

        System.out.println("t2线程结束");
    }
}
