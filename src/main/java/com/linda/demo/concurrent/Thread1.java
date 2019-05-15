package com.linda.demo.concurrent;

public class Thread1 implements  Runnable{
    WaitNotify waitNotify;

    public Thread1(WaitNotify waitNotify) {
        this.waitNotify = waitNotify;
    }

    @Override
    public void run() {
        waitNotify.setSignal();
    }
}
