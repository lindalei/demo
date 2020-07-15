package com.linda.demo.practice;

public class SwitchNull {
  public static void main(String[] args) {
    String param = null;
    switch (param) {
      case "good":
        System.out.println("good");
        break;
      case ("null"):
        System.out.println("null");
        break;
      default:
        System.out.println("default");
    }
  }
}
