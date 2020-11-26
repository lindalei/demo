package com.linda.demo.practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowNumberByFrequency {
  public static void main(String[] args) {
    ArrayList list = sortNumberByFrequency(3, 4, new int[]{5, 1, 6, 7}, new int[]{7, 5, 1, 6},
        new int[]{6, 7, 1, 5});
    System.out.println(list);
    ArrayList list2 =
        sortNumberByFrequency(4, 3, new int[]{4, 9, 2}, new int[]{9, 2, 3}, new int[]{5, 9, 2},
            new int[]{9, 4, 2});
    System.out.println(list2);
  }

  public static ArrayList sortNumberByFrequency(int n, int m, int[]... arrays) {
    assert arrays.length == n;
    Map<Integer, Integer> map = new HashMap<>();
    ArrayList result = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        map.put(arrays[i][j], map.get(arrays[i][j]) == null ? 1 : map.get(arrays[i][j]) + 1);
      }
    }
    Comparator<Map.Entry<Integer, Integer>> valueComparator =
        (o1, o2) -> o2.getValue() - o1.getValue();

    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
    Collections.sort(list, valueComparator);
    for (Map.Entry<Integer, Integer> entry : list) {
      result.add(entry.getKey());
    }
    return result;
  }
}
