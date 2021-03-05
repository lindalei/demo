package com.linda.demo.leetcode.greedy;

public class IntToRoman {
  public String intToRoman(int n) {
    int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int index = 0;
    StringBuilder sb = new StringBuilder();
    while (index < 13) {
      while (n >= nums[index]) {
        sb.append(romans[index]);
        n -= nums[index];
      }
      index++;
    }
    return sb.toString();
  }
}
