package com.linda.demo.bullCode;

import java.util.ArrayList;

public class ReorderArray {
    public static void reOrderArray(int [] array) {
        ArrayList<Integer> oddArray = new ArrayList<>();
        ArrayList<Integer> evenArray = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if(array[i]%2 !=0){
                oddArray.add(array[i]);
            }
            else{
                evenArray.add(array[i]);
            }
        }
        int k=0,i=0,j=0;
        while(k<oddArray.size()){
            array[k++]=oddArray.get(i++);
        }
        while(k>=oddArray.size() && k<array.length){
            array[k++] = evenArray.get(j++);

        }

    }
    public static void main(String[] args){
        int[] array ={1,2,3,4,5,6};
        reOrderArray(array);
    }
}
