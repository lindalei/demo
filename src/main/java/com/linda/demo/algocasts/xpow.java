package com.linda.demo.algocasts;

public class xpow {

    public static double powFast(double x, int n) {
        double result = 1;
        long N = Math.abs((long) n);
        while (N != 0) {
            if ((N & 1) == 1) {
                result *= x;
            }
            x *= x;
            N >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 11;
        System.out.println(x >> 3 & 1); //最低位与1相与
        System.out.println(powFast(2, 11));
    }


}
