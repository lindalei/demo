package com.linda.demo.concurrent;

import java.util.Arrays;
import java.util.List;

public class lamda {
    public static void main(String[] args){
        List<Integer> values= Arrays.asList(10,20,30,40);
        int sum =add(values);
        System.out.println(sum);

    }
    public static int add(List<Integer> values){
        values.parallelStream().forEachOrdered(System.out::println);
        return values.parallelStream().mapToInt(i->i).sum();
    }

}
