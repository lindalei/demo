package com.linda.demo.leetcode.dynamicPlan;

public class SellStockMultipleTimes {
  public int maxProfits(int[] prices) {
    int n = prices.length;
    /*
    dp[n][0]表示当天手上没股票，可能前一天就没有，也可能是前一天有，当天卖出了
    dp[n][1]表示当天手上有股票，可能前一天就有，也可能是前一天没有，当天买入了
     */
    int[][] dp = new int[n][2];
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[n - 1][0];
  }

  public static void main(String[] args) {
    int[] prices = {1, 8, 9, 3, 5, 2, 10};
    SellStockMultipleTimes sellStockOneTime = new SellStockMultipleTimes();
    System.out.println(sellStockOneTime.maxProfits(prices));
  }
}
