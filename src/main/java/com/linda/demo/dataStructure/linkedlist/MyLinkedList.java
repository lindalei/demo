package com.linda.demo.dataStructure.linkedlist;

public class MyLinkedList extends AbstractList {
  private int size;
  private Node first;
  private Node last;

  class Node {
    Object o;
    Node prev;
    Node next;

    public Node(Object o, Node prev, Node next) {
      this.o = o;
      this.prev = prev;
      this.next = next;
    }
  }

  @Override
  public Object get(int index) {

    return getNode(index).o;
  }

  private Node getNode(int index) {
    Node node = first;
    if (index <= (size >> 1)) {
      for (int i = 0; i < index; i++) {
        node = node.next;
      }
    } else {
      node = last;
      for (int i = size - 1; i > index; i--) {
        node = node.prev;
      }
    }
    return node;
  }

  @Override
  public Object set(int index, Object o) {
    checkSetPosition(index);
    Node node = getNode(index);
    Object oldValue = node.o;
    node.o = o;
    return oldValue;
  }

  @Override
  public void add(Object o) {
    add(size, o);
  }

  //@Override
  //  public void add(int index, Object o) {
  //    Node newNode;
  //    if (size == 0) {
  //      newNode = new Node(o, null, null);
  //      first = newNode;
  //      last = newNode;
  //    } else {
  //      Node prev = getNode(index - 1);
  //      if (prev == null) {
  //        newNode = new Node(o, null, getNode(index));
  //        first = newNode;
  //      } else {
  //        Node next = prev.next;
  //        newNode = new Node(o, prev, next);
  //        if (next == null) {
  //          prev.next = newNode;
  //          last = newNode;
  //        } else {
  //          prev.next = newNode;
  //          next.prev = newNode;
  //        }
  //      }
  //    }
  //
  //    size++;
  //  }

  @Override
  public void add(int index, Object o) {
    checkAddPosition(index);
    /*
    链表中无元素或者在最后添加
     */
    if (index == size) {
      linkAfter(o);
    } else {
      linkBefore(o, getNode(index));
    }

    size++;
  }

  private void linkBefore(Object o, Node node) {
    Node prev = node.prev;
    Node newNode = new Node(o, prev, node);
    //在0处插入
    if (prev == null) {
      first = newNode;
    } else {
      prev.next = newNode;
    }
  }

  private void checkAddPosition(int index) {
    if (index < 0 || index > size) {
      throw new RuntimeException("index out of bould");
    }
  }

  private void checkSetPosition(int index) {
    if (index < 0 || index >= size) {
      throw new RuntimeException("index out of bould");
    }
  }

  private void linkAfter(Object o) {
    Node node = last;
    Node newNode = new Node(o, node, null);
    //无元素
    if (node == null) {
      first = newNode;
      last = newNode;
    } else { //最后位置插入
      node.next = newNode;
      last = newNode;
    }
  }

  @Override
  public Object remove(Object o) {
    checkExist(o);
    int index = indexOf(o);
    Node node = getNode(index);
    Node prev = node.prev;
    Node next = node.next;
    if (prev != null & next != null) {
      prev.next = next;
      next.prev = prev;
    }
    if (prev == null) {
      first = next;
    }
    if (next == null) {
      last = prev;
    }
    size--;
    return node;
  }

  private void checkExist(Object o) {
    int index = indexOf(o);
    if (index == -1) {
      throw new RuntimeException("element not exist");
    }
  }

  @Override
  public void clear() {
    size = 0;
    first = null;
    last = null;
  }

  //  @Override
  //  public int indexOf(Object o) {
  //
  //    for (int i = 0; i < size; i++) {
  //      Node node = getNode(i);
  //      if (node.o.equals(o)) {
  //        return i;
  //      }
  //    }
  //    return -1;
  //  }
  @Override
  public int indexOf(Object o) {
    int index = 0;

    if (o == null) {
      for (Node node = first; node != null; node = node.next) {
        if (o == node.o) {
          return index;
        }
        index++;
      }
    } else {
      for (Node node = first; node != null; node = node.next) {
        if (o.equals(node.o)) {
          return index;
        }
        index++;
      }
    }
    return -1;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    if (size == 0) {
      stringBuilder.append("[]");
    } else {
      stringBuilder.append("[");
      for (int i = 0; i < size; i++) {
        stringBuilder.append(getNode(i).o).append(",");
      }
      stringBuilder.append("]");
    }
    return stringBuilder.toString();
  }
}
