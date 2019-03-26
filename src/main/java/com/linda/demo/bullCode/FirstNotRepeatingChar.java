package com.linda.demo.bullCode;

public class FirstNotRepeatingChar {
    public int FirstNotRepeatingCharSolution(String str) {
        char[] array= str.toCharArray();
        int seek=0;
        for (int i = 0; i <array.length ; i++) {
            for (int j = i; j < array.length; j++) {
                if(array[j] ==array[i]){
                    break;
                }
                if(j==array.length){
                    seek=i;
                }
            }
            if(seek==i){
               return seek;
            }


        }
        return 0;
    }
}
