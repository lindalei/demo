package com.linda.demo.practice;

public class ExceptionTest {

  public static void main(String[] args) {
    try {
      throwException(56);
    } catch (ClassNotFoundException e) {
      System.out.println("catch exception");
    }

  }

  public static void throwException(int i) throws ClassNotFoundException {
    if (i > 45) {
      //throw new StringIndexOutOfBoundsException();
      throw new ClassNotFoundException();
    } else {
      System.out.println(23);
    }
  }
}
