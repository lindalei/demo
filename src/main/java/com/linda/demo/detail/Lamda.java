package com.linda.demo.detail;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Lamda {
    public static Map<String, Function<Integer, Fruit>> map = new HashMap<>();

    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }

    public static Fruit getFruit(String type, Integer weight) {
        return map.get(type).apply(weight);
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple("green", 340),
                new Apple("pink", 100),
                new Apple("yellow", 450),
                new Apple("purple", 200),
                new Apple("red", 600)
        );

        //static array
        String[] arrays = {"hello", "world"};

        //dynamic arrays
        ArrayList<Apple> dynamicArrays = new ArrayList<>();
        dynamicArrays.addAll(apples);
        dynamicArrays.add(new Apple("white", 300));

        // filter, limit
        apples.stream().filter(a -> {
            System.out.println("filtering " + a.getColor());
            return a.getWeight() > 300;
        }).map(a -> {
            System.out.println("mapping " + a.getColor());
            return a.getColor();
        }).limit(2).collect(toList());

        //flat mapS
        System.out.println(Stream.of(arrays)
                .map(map -> map.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList()));

        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(2,4);
//        Stream<Stream<Integer[]>> biNumbers = numbers1.stream()
//                .map(n1->numbers2.stream()
//                        .map(n2->new Integer[]{n1,n2}));

        //mapping
        System.out.println(numbers1.stream()
                .map(n->n*n)
                .collect(toList()));

        List<int[]> biNumbers = numbers1.stream()
                .flatMap(n1->numbers2.stream()
                        .map(n2->new int[]{n1,n2}))
                .collect(toList());
        System.out.println(biNumbers);

        // findAny
        apples.stream()
                .filter(a->a.getWeight()>300)
                .findAny()
                .ifPresent(t->System.out.println(t.getColor()));

        // findFirst
        apples.stream()
                .filter(a->a.getWeight()>400)
                .findFirst()
                .ifPresent(t->System.out.println(t.getColor()));

        // anyMatch
        System.out.println(apples.stream()
                .anyMatch(t->t.getWeight()>300));


    }
}
