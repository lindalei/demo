package com.linda.demo.leetcode.greedy;

//https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
public class CanJump {
  public boolean canJump(int[] nums){
    int n=nums.length;
    int rightMost=0;
    for (int i = 0; i < n; i++) {
      if(i<=rightMost){
        rightMost=Math.max(rightMost,i+nums[i]);
        if(rightMost>=n-1){
          return true;
        }
      }
    }
    return false;
  }
}
