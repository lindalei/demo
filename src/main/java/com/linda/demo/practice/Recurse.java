package com.linda.demo.practice;

public class Recurse {
  public static int compute(int n){
    return n<=2?n:n*compute(n-1);


//    int result;
//    if(n<=2){
//      result=n;
//    }else{
//      result=compute(n-1)*n;
//    }
//    return result;
  }

  public static void main(String[] args) {
    System.out.println(compute(6));
  }
}
