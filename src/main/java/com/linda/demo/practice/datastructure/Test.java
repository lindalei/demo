package com.linda.demo.practice.datastructure;

public class Test {
  public static void main(String[] args) {
    MyLinkedList myLinkedList = new MyLinkedList();
    myLinkedList.add(2);
    myLinkedList.add(10);
    myLinkedList.add(3);
    //myLinkedList.display();
    for (Object i : myLinkedList) {
      System.out.println(i);
    }
  }
}
