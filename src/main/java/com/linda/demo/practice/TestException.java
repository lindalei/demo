package com.linda.demo.practice;

import java.util.concurrent.ConcurrentMap;

public class TestException {
  static ConcurrentMap<String,Integer> map;
  public static void main(String[] args) {
    try {
      int i = 3 / 0;
      map.put("hi",i);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
