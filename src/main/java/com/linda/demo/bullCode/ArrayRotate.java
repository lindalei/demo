package com.linda.demo.bullCode;

public class ArrayRotate {
    public static int[] rotateArray(int start, int[] array) {

        int leftNum = array.length - 1 - start;
        int rightNum = start + 1;
        int[] leftArray = new int[leftNum];
        int[] rightArray = new int[rightNum];
        int[] rotateArray = new int[array.length];

        for (int i = 0; i < leftNum; i++) {
            leftArray[i] = array[i + rightNum];
        }
        for (int i = 0; i < rightNum; i++) {
            rightArray[i] = array[i];
        }

        int i = 0, j = 0, k=0;
        while (i < leftNum) {
            rotateArray[i++] = leftArray[j++];
        }
        while (i >= leftNum && i < array.length) {
            rotateArray[i++] = rightArray[k++];
        }


        return rotateArray;
    }

    public static int minNumberInRotateArray(int [] array) {
        for (int i = 0; i <array.length ; i++) {
            if(array[i]>array[i+1]){
                return array[i+1];
            }
            continue;
        }
        return array[0];
    }

    public static void main(String[] args) {
        int[] array= {1,2,3,4,5};
//        for (int i = 0; i < 5; i++) {
//            System.out.println(rotateArray(2, array)[i]);
//        }
        System.out.println(minNumberInRotateArray(rotateArray(2,array)));
    }
}
