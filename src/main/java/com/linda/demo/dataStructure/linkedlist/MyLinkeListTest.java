package com.linda.demo.dataStructure.linkedlist;

public class MyLinkeListTest {
  public static void main(String[] args) {
    MyLinkedList myLinkedList = new MyLinkedList();
    myLinkedList.add(1);
    myLinkedList.add(2);
    myLinkedList.add(3);
    myLinkedList.remove(3);
    System.out.println(myLinkedList);
  }
}
