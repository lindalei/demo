package com.linda.demo.bullCode;

public class Binary1Count {
    //二进制中1个个数
    public static int NumberOf1(int n) {
//
//      if(n<0){
//         char[] charArray =Integer.toBinaryString(~(-n)+1).toCharArray();
//          for (int i = 0; i < charArray.length; i++) {
//              System.out.println(charArray[i]);
//          }
//      }
//      else{
//          char[] charArray =Integer.toBinaryString(n).toCharArray();
//          for (int i = 0; i < charArray.length; i++) {
//              System.out.println(charArray[i]);
//          }
//      }
//    }
        String s=null;
        if (n < 0) {
            s= Integer.toBinaryString(~(-n) + 1);

        } else {
            s = Integer.toBinaryString(n);
        }
        int count=0;
        char[] charArray=s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '1') {
                count++;
            }

        }
        return count;
    }



    public static void main(String[] args) {
        //NumberOf1(-3);
        System.out.println(NumberOf1(-10));
    }
}
