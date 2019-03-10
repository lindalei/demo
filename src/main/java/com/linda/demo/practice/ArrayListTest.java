package com.linda.demo.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {
    private static int[] elementData = {1,2,3,4,5};
    public static void main(String[] args){
       // elementData = Arrays.copyOf(elementData, 8);
//        for(int i=0;i<elementData.length;i++){
//            System.out.println(elementData[i]);
//        }
        System.arraycopy(elementData,0,elementData,2,3);
        for(int i=0;i<elementData.length;i++){
           System.out.println(elementData[i]);
        }
        ArrayList<Integer> e = new ArrayList<>();

    }
}
