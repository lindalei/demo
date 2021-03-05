package com.linda.demo.practice.FI;

public class Test {
  static Object test(FI fi) {
    /*
    传入函数式接口，调用接口的方法就可触发执行逻辑，而接口每次可以传入不同的lamda表达式，动态改变执行逻辑
     */
    Object object = fi.getObject();
    System.out.println(object);
    return object;

  }

  public static void main(String[] args) {
    test(() -> Orange.getOrange());
    test(() -> Tangerine.getTangerine());
  }
}
