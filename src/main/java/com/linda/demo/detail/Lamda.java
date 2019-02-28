package com.linda.demo.detail;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Lamda {
    public static Map<String, Function<Integer, Fruit>> map = new HashMap<>();

    enum WeightEnum {LOW, MIDDLE, HIGH};

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
        System.out.println(Stream.of(arrays)  //Stream<String>
                .map(map -> map.split(""))  //Stream<String[]>
                .flatMap(Arrays::stream) //Stream<Strings>
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

        // findAny
        apples.stream()
                .filter(a->a.getWeight()>300)
                .findAny()
                .map(a->a.getColor())
                .orElse("anyColor");

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

       // sqrtNumbers3.forEach(t->System.out.println(t[0]+", "+t[1]+", "+t[2]));

        //由函数生成流：iterate, 不会改变状态，菲波那契数组
        Stream.iterate(new int[]{0,1}, (t)->new int[]{t[1],t[0]+t[1]})
                .limit(20)
                .forEach(t->System.out.println(t[0]+", "+t[1]));

        //由文件生成流
        try {
            Files.lines(Paths.get("C:\\Users\\Linda\\IdeaProjects\\demo\\file.txt"),Charset.defaultCharset())
                    .flatMap(t->Arrays.stream(t.split(" ")))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            Files.lines(Paths.get("C:\\Users\\Linda\\IdeaProjects\\demo\\file.txt"),Charset.defaultCharset())
                    .map(t->t.split(" ")) //每行的元素String映射为String[]
                    .flatMap(Arrays::stream) //每个数组的元素为一个String, flatMap使得一行的多个数组元素映射为同一个流
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //由函数生成流：菲波那契序列
        Stream.iterate(new int[]{0,1}, (t)->new int[]{t[1],t[0]+t[1]})
                .limit(20)
        .map(t->t[0])
                .forEach(t->System.out.println(t));

        //由函数生成流：generate, 会改变状态，菲波那契序列
        IntSupplier fib =new IntSupplier(){
            int previous =0;
            int current =1;
            @Override
            public int getAsInt() {
                int oldValue = this.previous;
                int nextValue = this.previous+this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldValue;
            }
        };

        IntStream.generate(fib).limit(10).forEach(t->System.out.println(t));

        //6.收集器Collector

        //maxBy
        Comparator<Apple> appleComparator = Comparator.comparing(Apple::getWeight);
        System.out.println(apples.stream().collect(maxBy(appleComparator))); //Optional<Apple>

        //groupingBy
        System.out.println(apples.stream().collect(groupingBy(Apple::getColor)));//return [key,Apple]

        //summingInt
        System.out.println(apples.stream().collect(summingInt(Apple::getWeight)));

        //averagingInt
        System.out.println(apples.stream().collect(averagingInt(Apple::getWeight)));

        //summarizingInt, return IntSummaryStatistics: count,sum,min=, average=, max
        System.out.println(apples.stream().collect(summarizingInt(Apple::getWeight)));

        //joining
        System.out.println(apples.stream().map(Apple::getColor).collect(joining(", ")));

        //reducing
        System.out.println(apples.stream().collect(reducing(0, Apple::getWeight, (n1,n2)->n1+n2)));


        //多级分组, groupingBy第二个参数是一个Collector
        Map<String, Map<WeightEnum, List<Apple>>> appleMap = apples.stream().collect(
                groupingBy(Apple::getColor, groupingBy(a->
                {if(a.getWeight()<200) return WeightEnum.LOW;
                else if(a.getWeight()>350) return WeightEnum.MIDDLE;
                else return WeightEnum.HIGH;})));
        System.out.println(appleMap);

        //maxBy Collector as second parameter of groupingBy
        System.out.println(apples.stream().collect(groupingBy(Apple::getColor,
                maxBy(Comparator.comparingInt(Apple::getWeight)))));
        //counting, 每一种的个数
        System.out.println(apples.stream().collect(groupingBy(Apple::getColor,
                counting())));


        //partioningBy
        System.out.println(apples.stream().collect(partitioningBy(a->a.getWeight()>300,
                groupingBy(Apple::getColor))));

    }
}


