package com.linda.demo.dataStructure;

public class Recursive {
    public static void check(int a){
        a=a/2;
        System.out.println(a);
        while(a>6){
            check(a-1);

        }
        System.out.println("for "+a);
    }
    public static void main(String[] args){
        check(14);
    }
}
