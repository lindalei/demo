package com.linda.demo.leetcode.array.binaryTree;

import com.linda.demo.bullCode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Postorder2nary {
  public static List<Integer> preorderTraversal(TreeNode root) {
    LinkedList<TreeNode> nodes = new LinkedList<>();
    LinkedList<Integer> outputs = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      TreeNode node = nodes.pollLast();
      outputs.addFirst(node.val);
      if (node.right != null) {
        nodes.add(node.right);
      }
      if (node.left != null) {
        nodes.add(node.left);
      }
    }
    return outputs;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left=null;
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    node3.left=null;
    node3.right=null;
    node2.left = node3;
    node2.right=null;
    root.right = node2;
    List<Integer> outputs = preorderTraversal(root);
    for (int i = 0; i < outputs.size(); i++) {
      System.out.println(outputs.get(i));
    }
  }
}
