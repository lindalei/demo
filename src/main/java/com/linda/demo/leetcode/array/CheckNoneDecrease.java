package com.linda.demo.leetcode.array;

public class CheckNoneDecrease {

  public static boolean checkPossibility(int[] nums) {
    int count = 0;
    for (int i = nums.length-1; i >= 1; i--) {
      if (nums[i] >= nums[i - 1]) {
        continue;
      } else {
        if (count <= 1) {
          i--;
          count++;
          continue;
        }
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    //int[] nums1={4,2,3};
    int[] nums2={4,2,1};
    //System.out.println(checkPossibility(nums1));
    System.out.println(checkPossibility(nums2));
  }
}
