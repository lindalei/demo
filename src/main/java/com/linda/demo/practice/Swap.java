package com.linda.demo.practice;

public class Swap {
  public static void swap(int[] a) {
    int temp = a[0];
    a[0] = a[1];
    a[1] = temp;
  }

  public static void main(String[] args) {
    //    int[] a={2,3};
    //    swap(a);
    //    System.out.println(a[0]);
    //    System.out.println(a[1]);

//    int a = 3;
//    int b = 4;
//    a = a + b;
//    b = a - b;
//    a = a - b;
//    System.out.println(a);
//    System.out.println(b);
//
//    a = a ^ b;
//    b = a ^ b;
//    a = a ^ b;
//    System.out.println(a);
//    System.out.println(b);
    int c=Integer.SIZE-3;
    System.out.println(Integer.toBinaryString(c));
    System.out.println(Integer.toBinaryString(1<<c));
    System.out.println(true&&false||true);
  }
}
