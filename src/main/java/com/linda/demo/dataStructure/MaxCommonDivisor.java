package com.linda.demo.dataStructure;

public class MaxCommonDivisor {
    public static int getMaxCommonDivisor(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getMaxCommonDivisor(49, 42));
        int[] arrays = {14, 42, 21};
        int temp = arrays[0];
        int x, y;
        for (int i = 0; i < arrays.length - 1; i++) {
            x = temp;
            y = arrays[i + 1];
            temp = getMaxCommonDivisor(x, y);
        }
        System.out.println(temp);

    }
}
