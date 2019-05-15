package com.linda.demo.concurrent;

import java.util.Timer;
import java.util.TimerTask;

public class TimerThread extends Thread{


    public static void main(String[] args){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("正在执行");
            }
        },0,1000);
    }
}
