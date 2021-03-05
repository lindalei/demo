package com.linda.demo.leetcode.binaryTree;

public class TreeToDoublyList {
  static LinkedNode pre, head;

  public static LinkedNode treeToDoublyList(LinkedNode root) {
    if (root == null) {
      return null;
    }
    dfs(root);
    pre.right = head;
    head.left = pre;
    return head;
  }

  public static void dfs(LinkedNode cur) {
    if (cur == null) {
      return;
    }
    dfs(cur.left);
    if (pre != null) {
      pre.right = cur;
    } else {
      head = cur;
    }
    cur.left = pre;
    pre = cur;
    dfs(cur.right);
  }
}
