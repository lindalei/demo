package com.linda.demo.bullCode;

public class Sort {
    public static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int index = i - 1;
            while (index >= 0 && array[index] > temp) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = temp;
        }
        return array;
    }

    public static void quickSort(int[] array, int l, int r) {
        if(l<r){
            int i = l;
            int j = r;
            int x = array[i];
            while (i < j) {
                while (i < j && array[j] > x) {
                    j--;
                }
                if(i < j)
                    array[i++] = array[j];
                while (i < j && array[i] < x) {
                    i++;
                }
                if(i < j)
                    array[j--] = array[i];
            }
            array[i] = x;
            quickSort(array, l, i - 1);
            quickSort(array, i + 1, r);
        }

    }

    public static void mergeSort(int[] array, int start, int end, int[] temp){
        if(start<end){
            int mid = (start+end)/2;
            mergeSort(array,start,mid,temp);
            mergeSort(array,mid+1,end,temp);

            merge(array,start,mid,end,temp);

        }

    }

    public static void merge(int[] array, int start, int mid, int end, int[] temp){
        int i=start,j=mid+1,k=0;
        while(i<=mid&j<=end){
            if(array[i]<array[j]){
               temp[k++]=array[i++];
            }
            else{
                temp[k++]=array[j++];
            }
        }
        while(i<=mid){
            temp[k++]=array[i++];
        }
        while(j<=end){
            temp[k++]=array[j++];
        }
        k=0;
        while(start<=end){
            array[start++]=temp[k++];
        }


    }

    public static void main(String[] args) {
        int[] array = {4, 9, 3, 2, 10, 1};
        int[] sortedArray = insertSort(array);
        int[] temp=new int[array.length];
        mergeSort(array,0,array.length-1,temp);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
