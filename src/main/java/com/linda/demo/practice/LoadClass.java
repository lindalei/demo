package com.linda.demo.practice;

public class LoadClass {

  public static void main(String[] args) throws IllegalAccessException, InstantiationException {
    Class clazz = OddTest.class;
    OddTest o = (OddTest) clazz.newInstance();
    o.test();
  }
}
