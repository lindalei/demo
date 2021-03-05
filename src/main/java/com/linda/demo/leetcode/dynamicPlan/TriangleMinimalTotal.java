package com.linda.demo.leetcode.dynamicPlan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriangleMinimalTotal {
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[][] f = new int[n][n];
    f[0][0] = triangle.get(0).get(0);
    for (int i = 1; i < n; ++i) {
      f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
      for (int j = 1; j < i; ++j) {
        f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
      }
      f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
    }
    int minTotal = f[n - 1][0];
    for (int i = 1; i < n; ++i) {
      minTotal = Math.min(minTotal, f[n - 1][i]);
    }
    return minTotal;
  }

  public static void main(String[] args) {
    TriangleMinimalTotal triangleMinimalTotal = new TriangleMinimalTotal();
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> list1 = new ArrayList<>();
    Collections.addAll(list1, 2);
    list.add(0, list1);

    List<Integer> list2 = new ArrayList<>();
    Collections.addAll(list2, 3, 4);
    list.add(1, list2);

    List<Integer> list3 = new ArrayList<>();
    Collections.addAll(list3, 6, 5, 7);
    list.add(2, list3);

    List<Integer> list4 = new ArrayList<>();
    Collections.addAll(list4, 4, 1, 8, 3);
    list.add(3, list4);
    System.out.println(triangleMinimalTotal.minimumTotal(list));
  }
}
