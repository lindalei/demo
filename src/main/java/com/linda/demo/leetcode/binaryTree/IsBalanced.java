package com.linda.demo.leetcode.binaryTree;

import com.linda.demo.bullCode.TreeNode;

public class IsBalanced {
  public static boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isBalanced(root.left) && isBalanced(root.right)
        && Math.abs(depth(root.left) - depth(root.right)) <= 1;
  }

  public static int depth(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return Math.max(depth(node.left), depth(node.right)) + 1;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.left.left = null;
    root.left.right = null;
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(isBalanced(root));
  }
}
