package com.linda.demo.practice.datastructure;

import java.util.Iterator;

public class MyLinkedList implements Iterable {
  Node first = null;
  Node current = null;

  @Override
  public Iterator iterator() {
    return new Iterator() {
      Node node = first;

      @Override
      public boolean hasNext() {

        return node != null;
      }

      @Override
      public Object next() {
        int value = node.value;
        node = node.next;
        return value;
      }
    };
  }

  private class Node {
    int value;
    Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  public void add(int value) {
    Node node = new Node(value);
    if (first == null) {
      first = node;
      current = node;
    } else {
      current.next = node;
      current = node;
    }
  }


  public void display() {
    Node node = first;
    while (node != null) {
      System.out.println(node.value);
      node = node.next;
    }
  }
}
