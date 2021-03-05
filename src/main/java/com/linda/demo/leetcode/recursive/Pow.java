package com.linda.demo.leetcode.recursive;

public class Pow {
  public static double myPow(double x, int n) {
    //    if (x == 1) {
    //      return 1;
    //    }
    //    if (n == 1) {
    //      return x;
    //    }
    //    return x * myPow(x, n - 1);
    return n > 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
  }

  public static double quickMul(double x, int n) {
    if (n == 0) {
      return 1;
    }
    double y = quickMul(x, n / 2);
    return n % 2 == 0 ? y * y : y * y * x;
  }

  public static void main(String[] args) {
    double v = myPow(2.1, -2);
    System.out.println(v);
  }
}
