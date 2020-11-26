package com.linda.demo.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class LightTurn {
  public static void main(String[] args) {
    System.out
        .println(recurseChangeLight(new ArrayList<>(Arrays.asList(1, 1, 1, 0, 1, 1, 1, 1)), 2));
  }

  public static ArrayList recurseChangeLight(ArrayList<Integer> original, int days) {
    for (int i = 0; i < days; i++) {
      original = changeLight(original);
    }
    return original;
  }

  private static ArrayList changeLight(ArrayList<Integer> original) {
    ArrayList newArray = new ArrayList<Integer>();
    for (int i = 0; i < original.size(); i++) {
      if (i == 0) {
        if (original.get(i + 1) == 1) {
          newArray.add(1);
        } else {
          newArray.add(0);
        }
        continue;
      }
      if (i == original.size() - 1) {
        if (original.get(i - 1) == 1) {
          newArray.add(1);
        } else {
          newArray.add(0);
        }
        return newArray;
      }
      newArray.add(original.get(i - 1) == original.get(i + 1) ? 0 : 1);
    }
    return newArray;
  }
}
