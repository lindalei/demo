package com.linda.demo.dataStructure.linkedlist;

public interface List {
  int size();
  boolean isEmpty();
  boolean contains(Object e);
  Object get(int index);
  Object set(int index, Object o);
  void add(Object o);
  void add(int index,Object o);
  Object remove(Object o);
  void clear();
  int indexOf(Object o);
}
