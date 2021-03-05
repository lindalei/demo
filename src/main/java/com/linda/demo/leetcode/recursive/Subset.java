package com.linda.demo.leetcode.recursive;

import java.util.ArrayList;
import java.util.List;

public class Subset {
  List<Integer> temp = new ArrayList<>();
  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    int n = nums.length;
    for (int mask = 0; mask < (1 << n); mask++) {
      temp.clear();
      for (int i = 0; i < n; i++) {
        if ((mask & (1 << i)) != 0) {
          temp.add(nums[i]);
        }
      }
      result.add(new ArrayList<>(temp));
    }
    return result;
  }

  public static void main(String[] args) {
    Subset subset = new Subset();

    System.out.println(subset.subsets(new int[]{3,4,6}));

  }
}
