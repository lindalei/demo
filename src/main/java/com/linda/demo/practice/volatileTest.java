package com.linda.demo.practice;

public class volatileTest {

    public static volatile int count = 0;
    public static int a = 2;
    public static boolean test = false;

    public static void refresh() {
        a = 3;
        test = true;
    }

    public static void inc() {
        //这里延迟1毫秒，使得结果明显
        try {

            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        count++; //不是原子操作，线程A读取完count时，其他线程可能对count进行了改写，而A仍对老的值加1，所以最后的值会小于1000
    }

    public static void run() {
        if (test) {
            a++;
            System.out.println(a);

        }
    }

    public static void main(String[] args) {
        //同时启动1000个线程，去进行i++计算，看看实际结果
//        for (int i = 0; i < 1000; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    volatileTest.inc();
//                }
//            }).start();
//        } //这里每次运行的值都有可能不同,可能为1000
//        System.out.println("运行结果:Counter.count=" + volatileTest.count);


        Thread a1 = new Thread(new Runnable() {
            @Override
            public void run() {
                volatileTest.refresh();
            }
        });
        Thread a2 = new Thread(new Runnable() {
            @Override
            public void run() {
                volatileTest.run();
            }
        });


        a1.start();
        a2.start();
    }
}
