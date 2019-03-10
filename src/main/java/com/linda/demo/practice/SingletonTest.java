package com.linda.demo.practice;

public class SingletonTest {
    private static SingletonTest singletonTest =null; //一开始就生成对象
   // private static SingletonTest singletonTest = new SingletonTest(); //一开始就生成对象
    public static SingletonTest getSingletonTest(){
        return singletonTest;
    }
    public static synchronized SingletonTest getSyncSingletonTest(){
        if(singletonTest ==null){
            singletonTest= new SingletonTest(); //被调用的时候才new
        }
        return singletonTest;
    }
    public static void main(String[] args){
//        System.out.println(getSingletonTest());
//        System.out.println(getSingletonTest()); //同一个
        Thread a= new Thread(()-> System.out.println(getSyncSingletonTest()));
        a.start();
        Thread b= new Thread(()-> System.out.println(getSyncSingletonTest()));
        b.start();
        System.out.println(getSyncSingletonTest());
    }

}
