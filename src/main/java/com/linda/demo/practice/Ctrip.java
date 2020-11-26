package com.linda.demo.practice;

import java.util.HashMap;

public class Ctrip {
  public void getMaxSubString(String s, int len) {
    HashMap<String, Integer> results = new HashMap<>();
    char[] r = s.toCharArray();
    for (int i = 0; i < r.length; i++) {
      if (results.get(r[i]) == null) {
        results.put(String.valueOf(r[i]), 0);
      } else {
        results.put(String.valueOf(r[i]), results.get(r[i]) + 1);
      }
    }
  }

  public static void main(String[] args) {

  }
}
