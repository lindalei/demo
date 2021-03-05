package com.linda.demo.leetcode.recursive;

import java.util.LinkedList;
import java.util.List;

public class FullArrangement {
  static List<List<Integer>> res = new LinkedList<>();

  static void  backtrack(int[] nums, LinkedList<Integer> track) {
    // 触发结束条件
    if (track.size() == nums.length) {
      res.add(new LinkedList(track));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      // 排除不合法的选择
      if (track.contains(nums[i]))
        continue;
      // 做选择
      track.add(nums[i]);
      // 进入下一层决策树
      backtrack(nums, track);
      // 取消选择
      track.removeLast();
    }
  }

  public static void main(String[] args) {
    int[] nums={1,2,3};
    backtrack(nums, new LinkedList<>());
    System.out.println(res);
  }

}
