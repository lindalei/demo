package com.linda.demo.practice;

import java.util.List;
import java.util.Map;

public class OddTest {
  public static boolean isOdd(int i) {
    return i % 2 != 0; //取模运算
    //return (i&1)==1; //按位与，位运算

  }

  public void test() {
    System.out.println("test");
  }

  public static void main(String[] args) {
    System.currentTimeMillis();
    long a = System.currentTimeMillis();
    //System.out.println(isOdd(-3));
    System.out.println(123);
    System.out.println(456);
    System.out.println(789);
    System.out.println(System.currentTimeMillis() - a);
  }
}
