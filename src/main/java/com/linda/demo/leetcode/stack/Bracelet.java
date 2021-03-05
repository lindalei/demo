package com.linda.demo.leetcode.stack;

import java.util.Stack;

public class Bracelet {
  /**
   * @param str string字符串 the string
   * @return bool布尔型
   */
  public boolean isVaild(String str) {
    // write c here
    Stack<Character> results = new Stack();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != '(' && str.charAt(i) != ')') {
        return false;
      }
      if (str.charAt(i) == '(') {
        results.push('(');
      } else if (str.charAt(i) == ')') {
        if (results.isEmpty()) {
          return false;
        }
        if (results.peek() == '(') {
          results.pop();
        }
      }
    }

    if (results.isEmpty()) {
      return true;
    }
    return false;
  }
}

