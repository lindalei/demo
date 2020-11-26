package com.linda.demo.leetcode.array.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Node {
  int val;
  List<Node> children;

  public Node() {
  }


  public Node(int val, List<Node> children) {
    this.val = val;
    this.children = children;
  }
}

public class Preorder {
  public static List<Integer> preorder(Node root) {
    LinkedList<Node> nodes = new LinkedList<>();
    LinkedList<Integer> outputs = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      Node node = nodes.pollLast();
      outputs.add(node.val);
      Collections.reverse(node.children);
      for (Node child : node.children) {
        nodes.add(child);
      }
    }
    return outputs;
  }

  public static void main(String[] args) {
    Node node5= new Node(5,new ArrayList<>());
    Node node6= new Node(6,new ArrayList<>());
    List<Node> node3Children=new ArrayList<>();
    node3Children.add(node5);
    node3Children.add(node6);
    Node node3= new Node(3,node3Children);
    Node node2= new Node(2,new ArrayList<>());
    Node node4= new Node(4,new ArrayList<>());
    List<Node> rootChildren= new ArrayList<>();
    rootChildren.add(node3);
    rootChildren.add(node2);
    rootChildren.add(node4);
    Node root=new Node(1,rootChildren);
    List<Integer> outputs=preorder(root);
    System.out.println("hello");
    for (int i = 0; i < outputs.size(); i++) {
      System.out.println(outputs.get(i));
    }
  }
}
