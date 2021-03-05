package com.linda.demo.leetcode.stringRelated;

public class QueryStringOccurrenceNumber {

  public static int query(String original, String goal) {
    int count = 0;
    while (original.contains(goal)) {
      original = original.substring(original.indexOf(goal)+goal.length());
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(query("abc123abc890abc", "abc"));
  }
}
