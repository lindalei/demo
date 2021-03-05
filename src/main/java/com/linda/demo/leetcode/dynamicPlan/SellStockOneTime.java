package com.linda.demo.leetcode.dynamicPlan;

public class SellStockOneTime {
  public int maxProfits(int[] prices) {
    int n = prices.length;
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int i = 0; i < n; i++) {
      if (prices[i] < minPrice) {
        minPrice = prices[i];
      } else {
        maxProfit = prices[i] - minPrice;
      }
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int[] prices = {1, 8, 9, 3, 5, 2, 10};
    SellStockOneTime sellStockOneTime = new SellStockOneTime();
    System.out.println(sellStockOneTime.maxProfits(prices));
  }
}
