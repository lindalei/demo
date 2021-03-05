package com.linda.demo.leetcode.dynamicPlan;

public class SellStockMultipleTimesWithSellFee {
  public int maxProfits(int[] prices, int fee) {
    int n = prices.length;
    /*
    cash表示当天手上没股票，可能前一天就没有，也可能是前一天有，当天卖出了, 需要交手续费
    hold表示当天手上有股票，可能前一天就有，也可能是前一天没有，当天买入了
     */
    int cash = 0, hold = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      cash = Math.max(cash, hold + prices[i] - fee);
      hold = Math.max(hold, cash - prices[i]);
    }
    return cash;
  }

  public static void main(String[] args) {
    int[] prices = {1, 8, 9, 3, 5, 2, 10};
    SellStockMultipleTimesWithSellFee sellStockOneTime = new SellStockMultipleTimesWithSellFee();
    System.out.println(sellStockOneTime.maxProfits(prices, 2));
  }
}
