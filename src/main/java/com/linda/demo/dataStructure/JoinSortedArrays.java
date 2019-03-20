package com.linda.demo.dataStructure;

import org.apache.tomcat.util.buf.StringUtils;

import java.util.Arrays;

public class JoinSortedArrays {
    public static int[] joinSorted(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] array = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                array[k++] = arr1[i++];
            } else {
                array[k++] = arr2[j++];
            }
        }
        while (i < n1) {
            array[k++] = arr1[i++];
        }
        while (j < n2) {
            array[k++] = arr2[j++];
        }
        return array;

    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3, 5, 7};
        int[] array2 = new int[]{2, 4, 6, 8, 9};
        int[] array = joinSorted(array1, array2);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}