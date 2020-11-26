package com.linda.demo.leetcode.array.array;

public class MergeSortedArrays {
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int t = m + n - 1;
    int m1 = m - 1;
    int n1 = n - 1;
    while (m1 >= 0 && n1 >= 0) {
      nums1[t--] = nums1[m1] > nums2[n1] ? nums1[m1--] : nums2[n1--];
    }
    System.arraycopy(nums2, 0, nums1, 0, n1 + 1);
  }

  public static void main(String[] args) {
    int[] a1 = {1, 3, 4, 8, 0, 0, 0};
    int[] a2 = {2, 7, 10};
    merge(a1, 4, a2, 3);
    for (int i = 0; i < a1.length; i++) {
      System.out.println(a1[i]);
    }

  }
}
