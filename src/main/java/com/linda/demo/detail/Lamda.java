package com.linda.demo.detail;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Lamda {
    public static Map<String, Function<Integer, Fruit>> map= new HashMap<>();
    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }

    public static Fruit getFruit(String type, Integer weight){
        return map.get(type).apply(weight);
    }
    public static void main(String[] args){
        System.out.print(getFruit("apple", 100).getWeight());
    }
}
