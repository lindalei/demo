package com.linda.demo.bullCode;

import java.util.ArrayList;

public class TreePathSum {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
      while(root!=null){
          FindPath(root.left,target-root.val);
      }
    }

    private  ArrayList<Integer>findPathSum(TreeNode root, int target){

    }
}
