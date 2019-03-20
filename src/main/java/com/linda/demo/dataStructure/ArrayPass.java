package com.linda.demo.dataStructure;

public class ArrayPass {

    public static int[] getArrays(int[] arrays) {
        arrays[0] =12;
        int[] temp=arrays;
        temp[1]=9; //传值引用，指向的是地址
        return arrays;
    }


    public static void main(String[] args) {
        int[] arrays={4,6,8};
        int[] results =getArrays(arrays);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }

    }
}
