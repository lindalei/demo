package com.linda.demo.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicationKing {
  public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], 1);
      } else {
        map.put(nums[i], map.get(nums[i]) + 1);
      }
    }
    Map.Entry<Integer, Integer> duplicationKey = null;
    Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
    for (Map.Entry<Integer, Integer> entry : entries) {
      if (duplicationKey == null || entry.getValue() > duplicationKey.getValue()) {
        duplicationKey = entry;
      }
    }
    return duplicationKey.getKey();
  }

  public static void main(String[] args) {
    DuplicationKing duplicationKing = new DuplicationKing();
    System.out.println(duplicationKing.majorityElement(new int[]{3, 3, 4, 5, 6, 7, 4, 4, 3, 2, 3}));
  }
}
