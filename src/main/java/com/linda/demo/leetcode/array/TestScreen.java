package com.linda.demo.leetcode.array;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TestScreen {
  public static List<Integer> compute(List<Integer> list) {
    List<Integer> sortedList = removeDuplicate(list);
    Collections.sort(sortedList);
    List<Integer> results = new LinkedList<>();
    int i = 0;
    int j = sortedList.size() - 1;
    for (int m = 0; m < sortedList.size(); m++) {
      Integer value = sortedList.get(m);

      while (i < sortedList.size() && j >= 0) {
        if (sortedList.get(i) + sortedList.get(j) < value) {
          i++;
        } else if (sortedList.get(i) + sortedList.get(j) > value) {
          j--;
        } else {
          results.addAll(Arrays.asList(sortedList.get(i), sortedList.get(j), value));
        }
      }
    }
    return results;
  }

  private static List<Integer> removeDuplicate(List<Integer> list) {
    Set<Integer> setResult = new HashSet<>();
    List<Integer> results = new LinkedList<>();
    setResult.addAll(list);
    results.addAll(setResult);
    return results;
  }

  public static void main(String[] args) {
    List<Integer> origin = Arrays.asList(-5, 5, 0, 3, 3, -2, -1,-4,-3,2,2);
    List<Integer> results = removeDuplicate(origin);


    results.stream().forEach(i -> System.out.println(i));
  }
}
