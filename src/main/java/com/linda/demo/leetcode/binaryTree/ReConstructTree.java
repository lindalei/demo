package com.linda.demo.leetcode.binaryTree;

import com.linda.demo.bullCode.TreeNode;

import java.util.HashMap;

public class ReConstructTree {
  static int[] preOrder;
  static HashMap<Integer, Integer> dic = new HashMap<>();

  public static TreeNode buildTree(int[] preorder, int[] inorder) {

    preOrder = preorder;
    for (int i = 0; i < inorder.length; i++) {
      dic.put(inorder[i], i);
    }
    return recur(0, 0, inorder.length - 1);
    //not work
    //    TreeNode root = new TreeNode(preorder[0]);
    //    int preLength=0;
    //    for (int i = 0; i < inorder.length; i++) {
    //      if (inorder[i] == root.val) {
    //        preLength = i;
    //        break;
    //      }
    //    }
    //
    //    int rootIndex=0;
    //    int inLength=preorder.length-1-preLength;
    //
    //    int[] leftPreOrder={};
    //    System.arraycopy(preorder,rootIndex+1,leftPreOrder,0,preLength);
    //    int[] rightPreOrder={};
    //    System.arraycopy(preorder,rootIndex+preLength+1,rightPreOrder,0,inLength);
    //    int[] leftInOrder={};
    //    System.arraycopy(inorder,0,leftInOrder,0,preLength);
    //    int[] rightInOrder={};
    //    System.arraycopy(inorder,preLength+1,rightInOrder,0,inLength);
    //
    //    buildTree(leftPreOrder,leftInOrder);
    //    buildTree(rightPreOrder,rightInOrder);
    //    return root;
  }

  //第一个参数为子树根节点在preOrder中的index, left, right为子树在inOrder中的index
  public static TreeNode recur(int root, int left, int right) {
    if (left > right) {
      return null;
    }
    TreeNode node = new TreeNode(preOrder[root]);
    int i = dic.get(preOrder[root]);

    node.left = recur(root + 1, left, i - 1);
    node.right = recur(i - left + root + 1, i + 1, right);
    return node;
  }

  public static void main(String[] args) {
    int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
    int[] inOrder = {4, 2, 5, 1, 6, 3, 7};
    TreeNode treeNode = buildTree(preOrder, inOrder);
    System.out.println(treeNode.val);
  }
}
