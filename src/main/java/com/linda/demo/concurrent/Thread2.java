package com.linda.demo.concurrent;

public class Thread2 implements  Runnable{
    WaitNotify waitNotify;

    public Thread2(WaitNotify waitNotify) {
        this.waitNotify = waitNotify;
    }

    @Override
    public void run() {
        waitNotify.getSignal();
    }
}
