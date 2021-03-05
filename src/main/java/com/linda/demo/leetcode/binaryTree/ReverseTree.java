package com.linda.demo.leetcode.binaryTree;

import com.linda.demo.bullCode.TreeNode;

public class ReverseTree {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;
  }
}
