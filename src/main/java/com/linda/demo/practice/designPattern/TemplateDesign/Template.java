package com.linda.demo.practice.designPattern.TemplateDesign;

public abstract class Template {
  public void print() {
    fly();
    System.out.println("printing, please wait");
    walk();
  }

  protected void fly() {
    System.out.println("flying");
  }

  protected void walk() {
    System.out.println("walk");
  }
}
