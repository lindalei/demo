package com.linda.demo.detail;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
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
                new Apple("green", 440),
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
        Stream<Stream<Integer[]>> biNumbers0 = numbers1.stream()
                .map(n1->numbers2.stream()
                        .map(n2->new Integer[]{n1,n2}));

        Stream<Integer[]> biNumbers2 = numbers1.stream()
                .flatMap((n1->numbers2.stream()
                        .map(n2->new Integer[]{n1,n2})));

        biNumbers2.forEach(t->System.out.println(t[0]+"-"+t[1]));

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

        //reduce sums with initial value
        System.out.println(apples.stream()
                .map(Apple::getWeight)
        .reduce(0,Integer::sum)); //有装箱成本

        //reduce sums with initial value
        System.out.println(apples.stream()
                .mapToInt(Apple::getWeight)
                .sum()); //没有装箱成本,sum有默认值0，而max没有，直接调用max返回OptionalInt,需要再调用orElse

        //reduce sum no initial value
        System.out.println(apples.stream()
                .map(Apple::getWeight)
                .reduce(Integer::sum).orElse(300));

        //max
        System.out.println(apples.stream()
                .map(Apple::getWeight)
                .reduce(Integer::max).orElse(100));

        //ntStream max, from Stream<>to IntStream: mapToInt()
        System.out.println(apples.stream()
                .mapToInt(Apple::getWeight)
                .max().orElse(3));

        //count
        System.out.println(apples.stream()
      .count());

        //collect color string: to list
        System.out.println(apples.stream()
                .map(Apple::getColor)
        .distinct()
        .sorted()
        .collect(toList()));

        //collect color string: by lamda
        System.out.println(apples.stream()
                .map(Apple::getColor)
                .distinct()
                .sorted()
                .reduce("",(c1,c2)->c1+" "+c2));

        //collect color string: joining
        System.out.println(apples.stream()
                .map(Apple::getColor)
                .distinct()
                .sorted()
                .collect(joining()));

        //IntStream count
        System.out.println(
                IntStream.rangeClosed(1,200).count());

        //from IntStream to Steam<>, boxed()
        System.out.println(
                IntStream.rangeClosed(1,200).boxed().collect(toList()));

        //勾股数
        Stream<int[]> sqrtNumbers=
                IntStream.rangeClosed(1,100)
                        .boxed().flatMap(a->
                        IntStream.rangeClosed(a,100)
        .filter(b->Math.sqrt(a*a+b*b)%1==0)
        .boxed()
        .map(b-> new int[]{a,b,(int)Math.sqrt(a*a+b*b)}));

        Stream<int[]> sqrtNumbers2=
                IntStream.rangeClosed(1,100)
                        .boxed().flatMap(a->
                        IntStream.rangeClosed(a,100)
                                .filter(b->Math.sqrt(a*a+b*b)%1==0)
                                .mapToObj(b-> new int[]{a,b,(int)Math.sqrt(a*a+b*b)}));

        //先生成数组再过滤
        Stream<int[]> sqrtNumbers3=
                IntStream.rangeClosed(1,100)
                        .boxed().flatMap(a->
                        IntStream.rangeClosed(a,100)
                                .mapToObj(b-> new int[]{a,b,(int)Math.sqrt(a*a+b*b)})
                .filter(t->t[2]%1==0));

        sqrtNumbers3.forEach(t->System.out.println(t[0]+", "+t[1]+", "+t[2]));
    }
}
