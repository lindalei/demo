package com.linda.demo.bullCode;

public class ReplaceString {
    public static String replaceSpace(StringBuffer str) {
        String str1=str.toString();
        while (str1.indexOf(' ') != -1) {
            str1 = str1.replaceFirst("\\s", "%20");

        }
        return str1;
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("we are happy")));
    }
}
