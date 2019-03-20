package com.linda.demo.bullCode;

public class SumTotal {
    public static int Sum_Solution(int n) {
//        int sum=0,a=0;
//        while(a<n+1){
//            sum+=a++;
//        }
//
//        return sum;
        if(n==1){
            return 1;
        }
        else{
            return Sum_Solution(n-1)+n;
        }

    }

    public static void main(String[] args){
        System.out.println(Sum_Solution(9));
    }
}
