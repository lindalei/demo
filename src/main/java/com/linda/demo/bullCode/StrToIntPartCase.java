package com.linda.demo.bullCode;

public class StrToIntPartCase {
    public static int StrToInt(String str) {
        if (str.equals("0") || checkNum(str)) {
            return 0;
        }
        int[] intNum = new int[str.length()];
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            intNum[i] = str.charAt(i) - 48;
            if (str.charAt(0) == '+' || str.charAt(0) == '-') {
                intNum[0] = 0;
            }

        }
        for (int i = 0; i < intNum.length; i++) {
            sum += intNum[i] * Math.pow(10, intNum.length - 1 - i);
        }
        return sum;
    }

    public static boolean checkNum(String str) {
        if (str.matches("^.*[^0-9]|[^-0-9]s.*$")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt("45678"));
        System.out.println(StrToInt("+45678"));
        System.out.println(StrToInt("-45678"));
        System.out.println(StrToInt("0"));
        System.out.println(StrToInt("34a"));
    }
}
