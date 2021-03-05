package com.linda.demo.leetcode.greedy;

//https://leetcode-cn.com/problems/can-place-flowers/solution/fei-chang-jian-dan-de-tiao-ge-zi-jie-fa-nhzwc/
public class CanPlaceFlower {
  public boolean canPlaceFlower(int[] flowerbed, int n) {
    for (int i = 0; i < flowerbed.length && n > 0; ) {
      if (flowerbed[i] == 1) {
        i += 2;
        //为什么最后一个位置肯定可以种植
      } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
        n--;
        i += 2;
      } else {
        i += 3;
      }
    }
    return n <= 0;
  }
}
