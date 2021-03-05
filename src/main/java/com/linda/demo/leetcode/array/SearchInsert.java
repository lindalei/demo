package com.linda.demo.leetcode.array;

//给定有序数据和target，插入target并返回其在数组中的下标
public class SearchInsert {
  public int searchInsert(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= target) {
        return i;
      }
    }
    return nums.length;
  }

  public int searchInsert1(int[] nums, int target) {
    int left = 0;
    int ans = nums.length;
    int right = nums.length - 1;
    while (left < right) {
      int mid = ((right - left) >> 1) + left;;
      if (target <= nums[mid]) {
        ans = mid;
        right = mid - 1;
      } else {
        left=mid+1;
      }
    }
    return ans;
  }
}
