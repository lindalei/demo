package com.linda.demo.detail;

import java.text.SimpleDateFormat;
import java.util.Date;

public class lamdaLazy {

//        public static void main(String[] args) {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//            log(1, "Rose: " + sdf.format(new Date()) + " 进行了转账操作");
//            log(2, "Jack: " + sdf.format(new Date()) + " 进行了取钱操作");
//        }
//
//        //在level=2的时候也进行了字符串拼接，浪费
//        public static void log(int level, String message) {
//            if (level == 1) { // 用户日志
//                System.out.println(message);
//            }
//
//        }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        log(1, ()->{System.out.println("级别 1");return "Rose: " + sdf.format(new Date()) + " 进行了转账操作";});
        log(2, ()->{System.out.println("级别 2");return "Jack: " + sdf.format(new Date()) + " 进行了取钱操作";});
    }

    //在level=2的时候也进行了字符串拼接，浪费
    public static void log(int level, StringBuilider builder) {
        if (level == 1) { // 用户日志
          System.out.print(builder.buildString());
        }

    }

    interface StringBuilider{
        String buildString();
    }


}
