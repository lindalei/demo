package com.linda.demo.dataStructure.linkedlist;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LinkedListConcurrentTest {
  public static void main(String[] args) {
    LinkedList<Integer> integers = new LinkedList<>();
    //Collection<Integer> cl = Collections.synchronizedCollection(integers);
    ConcurrentLinkedQueue<Object> objects = new ConcurrentLinkedQueue<>();
    for (int i = 0; i < 4; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          objects.add(3);
          System.out.println(objects);
        }
      }).start();
    }
  }

  //  public static void main(String[] args) {
  //    LinkedList<Object> objects = new LinkedList<>();
  //    objects.add(2);
  //    objects.add(2);
  //    System.out.println(objects.indexOf(2));
  //
  //  }
}
