package com.linda.demo.bullCode;

public class ArraySearch {
    public static boolean Find(int target, int [][] array) {
        int columnNum=array[0].length;
        int rowNum=array.length;
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<columnNum;j++){
                if(target==array[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] array={{1,2,3},{4,5,6}};
        System.out.println(Find(4,array));


    }

}