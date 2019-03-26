package com.linda.demo.bullCode;

public class Power {
    public static double Power(double base, int exponent) {
        if(exponent==0){
            return 1.0;
        }
        else if(exponent>0){
            if(exponent==1){
                return base;
            }
            else{
                return Power(base,exponent-1)*base;
            }
        }
        else{
            int n=-exponent;
            if(n==1){
                return 1/base;
            }
            else{
                return 1/(Power(base,n-1)*base);
            }
        }

    }
    public static void main(String[] args){
        System.out.println(Power(3.14,-2));
    }
}
