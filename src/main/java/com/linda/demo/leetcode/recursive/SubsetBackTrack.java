package com.linda.demo.leetcode.recursive;

import java.util.ArrayList;
import java.util.List;

public class SubsetBackTrack {
  List<Integer> tmp = new ArrayList<>();
  List<List<Integer>> ans = new ArrayList<>();

  public List<List<Integer>> subSet(int[] nums) {
    dfs(0, nums);
    return ans;
  }

  public void dfs(int cur, int[] nums) {
    if (cur == nums.length) {
      ans.add(tmp);
      return;
    }

    tmp.add(nums[cur]);
    dfs(cur + 1, nums);
    tmp.remove(tmp.size() - 1);
    dfs(cur + 1, nums);
  }
}
