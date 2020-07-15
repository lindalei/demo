package com.linda.demo.practice.threadLocal;

public class ThreadLocalTest {
  public static void main(String[] args) {
    ThreadLocal<Integer> i1= new ThreadLocal<Integer>(){
      @SuppressWarnings("unchecked")
      @Override
      protected Integer initialValue() {
        return 10;
      }
    };
    ThreadLocal<Integer> i2= new ThreadLocal<Integer>(){
      @SuppressWarnings("unchecked")
      @Override
      protected Integer initialValue() {
        return 15;
      }
    };
    System.out.println(i1.get());
    System.out.println(i2.get());

  }
}
