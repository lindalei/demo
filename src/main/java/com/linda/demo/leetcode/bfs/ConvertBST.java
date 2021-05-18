package com.linda.demo.leetcode.bfs;

import com.linda.demo.bullCode.TreeNode;

//https://leetcode-cn.com/problems/convert-bst-to-greater-tree/solution/ba-er-cha-sou-suo-shu
// -zhuan-huan-wei-lei-jia-sh-14/
public class ConvertBST {
  int sum = 0;

  public TreeNode convertBSF(TreeNode root) {
    if (root != null) {
      convertBSF(root.right);
      sum += root.val;
      root.val = sum;
      convertBSF(root.left);
    }
    return root;
  }
}
