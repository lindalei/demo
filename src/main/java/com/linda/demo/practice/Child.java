package com.linda.demo.practice;

public class Child extends Parent {
  private int m=40;
  static int g;

  public static void main(String[] args) throws ClassNotFoundException {
//    Class child= Class.forName("com.linda.demo.practice.Child");
//    for (Field field : child.getDeclaredFields()) {
//      System.out.println(field);
    System.out.println(g);
//    }
  }
}
