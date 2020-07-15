package com.linda.demo.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FinallyCatch {
  public static void main(String[] args) throws ClassNotFoundException {
    try {
      FileInputStream file = new FileInputStream("c://documents/file.txt");
    } catch (FileNotFoundException e) {
      //e.printStackTrace();
      System.out.println("file exeption");
    } finally {
      throw new ClassNotFoundException("class");
//      try {
//        Class clazz = Class.forName("Test.java");
//      } catch (ClassNotFoundException e) {
//        //e.printStackTrace();
//        System.out.println("class exception");
      }
    }
  }

