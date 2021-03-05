package com.linda.demo.leetcode.recursive;

public class StrStr {
  public static int strStr(String haystack, String needle) {
    //return haystack.indexOf(needle);

    if (needle == "") {
      return 0;
    }
    int hayLength = haystack.length();
    int needleLength = needle.length();
    for (int i = 0; i < hayLength - needleLength + 1; i++) {
      int j;
      for (j = 0; j < needleLength; j++) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          break;
        }
      }
      if (j == needleLength) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int i = strStr("abcgood", "good");
    System.out.println(i);
  }
}
