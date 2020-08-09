package com.linda.demo.practice.threadLocal;

public class ThreeOperator {
  public static void main(String[] args) {
    Integer integer=null;
    //三目运算符，类型对齐，有基本类型会自动拆箱，Integer.intValue（）NPE异常
    int i=3>2?integer:4;
    System.out.println(i);
  }
}
