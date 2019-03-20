package com.linda.demo.bullCode;

public class StrToInt {
    public static int transfer(String str) {
        if(str.equals("") || str.length()==0){
            return 0;
        }
        char[] chars = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '-' || chars[i] =='+') {
                continue;
            }
            if (chars[i] < 48 || chars[i] > 57) {
                return 0;
            }
            sum = sum * 10 + chars[i] - 48;
        }
        return chars[0]=='-'? sum*(-1): sum;
    }
    public static void main(String[] args){
        System.out.println(transfer("+567"));
        System.out.println(transfer("-567"));
        System.out.println(transfer("a567"));

    }
}
