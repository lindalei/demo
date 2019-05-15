package com.linda.demo.concurrent;

import org.hibernate.validator.internal.constraintvalidators.bv.time.pastorpresent.PastOrPresentValidatorForReadableInstant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MockLock implements Lock {

    private boolean isLocked=false;
    private int lockCount;
    private Thread lockThread;
    @Override
    public synchronized void lock() {
        Thread currentThread= Thread.currentThread();
        while(isLocked && lockThread!=currentThread){ //可重入，同一个线程无需等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked=true;
        lockCount++;
        lockThread=currentThread;

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        Thread currentThread=Thread.currentThread();
        if(lockThread==currentThread){
            lockCount--;
            if(lockCount==0){
                isLocked=false;

            }
        }

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
