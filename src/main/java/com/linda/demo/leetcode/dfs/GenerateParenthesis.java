package com.linda.demo.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
public class GenerateParenthesis {
  public List<String> generateParenthesis(int n) {
    ArrayList<String> res = new ArrayList<>();
    if (n == 0) {
      return res;
    }
    String cur = "";
    dfs(cur, n, n, res);
    return res;
  }

  //left, right表示左右括号还剩下的个数，也就是还可以使用的个数
  public void dfs(String cur, int left, int right, ArrayList<String> res) {
    if (left == 0 && right == 0) {
      res.add(cur);
      return;
    }
    //(个数大于)时要剪枝
    if (left > right) {
      return;
    }
    if (left > 0) {
      dfs(cur + "(", left - 1, right, res);
    }
    if (right > 0) {
      dfs(cur + ")", left, right - 1, res);
    }
  }
}
