package com.linda.demo.leetcode.stringRelated;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
public class LengthOfLongestSubstring {
  //not work
  //  List<Integer> list = new ArrayList<>();
  //
  //  public int lengthOfLongestSubstring(String s) {
  //    for (int i = 0; i < s.length(); i++) {
  //      String subString = s.substring(i);
  //      list.add(NoneRepeatSubstring(subString));
  //    }
  //    return (int) getMax(list);
  //  }
  //
  //  public int NoneRepeatSubstring(String s) {
  //    for (int i = 0; i < s.length(); i++) {
  //      if (s.charAt(i) != s.charAt(i + 1)) {
  //        continue;
  //      } else {
  //        return i + 1;
  //      }
  //    }
  //    return s.length();
  //  }
  //
  //  private Object getMax(List s) {
  //    Iterator it = s.iterator();
  //
  //    Object max = it.next();
  //
  //    while (it.hasNext()) {
  //      Comparable obj = (Comparable) it.next();
  //      if (obj.compareTo(max) > 0) {
  //        max = obj;
  //      }
  //    }
  //    return max;
  //  }

  //https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
  public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int ans = 0;
    int rk = -1;
    for (int i = 0; i < s.length(); i++) {
      if (i != 0) {
        set.remove(s.charAt(i - 1));
      }
      while (rk < s.length() - 1 && !set.contains(s.charAt(rk + 1))) {
        set.add(s.charAt(rk + 1));
        rk++;
      }
      ans = Math.max(ans, rk - i + 1);
    }
    return ans;
  }
}
