package com.linda.demo.leetcode.recursive;

public class LongestCommonPrefix {

  static String longestCommonPrefix(String[] strs) {
    if(strs.length==0 ||strs==null){
      return "";
    }
    StringBuffer result = new StringBuffer();
    String first = strs[0];
    int minLength = minLength(strs);
    boolean flag = true;
    for (int i = 0; i < minLength; i++) {
      for (int j = 1; j < strs.length; j++) {
        if (first.charAt(i) == strs[j].charAt(i)) {
          continue;
        } else {
          flag = false;
          break;
        }
      }
      if (flag) {
        result.append(first.charAt(i));
      }
    }
    return result.toString();
  }

  static int minLength(String[] strs) {
    int length = strs[0].length();
    for (int i = 1; i < strs.length; i++) {
      if (strs[i].length() < length) {
        length = strs[i].length();
      }
    }
    return length;
  }

  public static void main(String[] args) {
    String[] chars = {"flower", "flow", "fly"};
    System.out.println(longestCommonPrefix(chars));
  }
}
