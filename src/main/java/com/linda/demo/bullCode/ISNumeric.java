package com.linda.demo.bullCode;

public class ISNumeric {
    public boolean isNumeric(char[] str) {

       String string = String.valueOf(str);
       return string.matches("[\\+\\-]]?\\d+(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }
}
