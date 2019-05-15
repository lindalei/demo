package com.linda.demo.concurrent;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class TestMockLock {
    MockLock mockLock= new MockLock();
    public void a(){
        mockLock.lock();
        System.out.println("a");
        b();
        mockLock.unlock();
    }

    public void b(){
        mockLock.lock();
        System.out.println("b");
        c();
        mockLock.unlock();
    }

    public void c(){
        mockLock.lock();
        System.out.println("c");
        mockLock.unlock();
    }
    public static void main(String[] args){
        TestMockLock testMockLock= new TestMockLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                testMockLock.a();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                testMockLock.a();
            }
        }).start();
    }
}
