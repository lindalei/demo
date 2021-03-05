package com.linda.demo.leetcode.stringRelated;

public class Asterisk {

  public static int calculteLength(String s){
    int length=0;
    for (int i = 0; i < s.length(); i++) {
      if(s.charAt(i)!='*'){
        length++;
      }
      else if(s.charAt(i)=='*'){
        length=length*2;
      }
    }
    return length;
  }

  public static void main(String[] args) {
    System.out.println(calculteLength("ab**c"));
  }
}
