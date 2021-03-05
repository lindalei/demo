package com.linda.demo.leetcode.recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumCombination {
  Map<Character, String> phoneMap = new HashMap<Character, String>() {{
    put('2', "abc");
    put('3', "def");
    put('4', "ghi");
    put('5', "jkl");
    put('6', "mno");
    put('7', "pqrs");
    put('8', "tuv");
    put('9', "wxyz");
  }};

  public List<String> combine(String digits) {
    List<String> res = new ArrayList();
    if (digits.length() == 0) {
      return res;
    }
    recursiveCall(res, digits, new StringBuilder(), 0);
    return res;
  }

  public void recursiveCall(List<String> res, String digits, StringBuilder builder, int index) {
    if (index == digits.length()) {
      res.add(builder.toString());
      return;
    }
    char c = digits.charAt(index);
    String s = phoneMap.get(c);
    for (int j = 0; j < s.length(); j++) {
      builder.append(s.charAt(j));
      recursiveCall(res, digits, builder, index + 1);
      builder.deleteCharAt(builder.length() - 1);
    }
  }

  public static void main(String[] args) {
    PhoneNumCombination phoneNumCombination = new PhoneNumCombination();
    List<String> combine = phoneNumCombination.combine("234");
    System.out.println(combine);
  }
}

