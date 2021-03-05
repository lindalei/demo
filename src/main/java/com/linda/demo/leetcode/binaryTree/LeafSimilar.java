package com.linda.demo.leetcode.binaryTree;

import com.linda.demo.bullCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {
  List<Integer> list1 = new ArrayList<>();
  List<Integer> list2 = new ArrayList<>();

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> dfs1 = dfs(root1, list1);
    List<Integer> dfs2 = dfs(root2, list2);
    return dfs1.equals(dfs2);
  }

  public List<Integer> dfs(TreeNode node, List<Integer> list) {
    if (node != null) {
      if (node.left == null & node.right == null) {
        list.add(node.val);
      }
      dfs(node.left, list);
      dfs(node.right, list);
    }
    return list;
  }
}
