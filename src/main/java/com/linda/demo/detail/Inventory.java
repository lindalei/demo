package com.linda.demo.detail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Inventory {
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e))
                result.add(e);
        }
        return result;

    }

    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(new Apple("green", 100),
                new Apple("red", 200),
                new Apple("red", 300));
        List<Apple> filteredApples = filter(apples, (Apple a)->"red".equals(a.getColor()));
        filteredApples.stream().forEach((Apple a)->System.out.println(a.getWeight()));
    }



}