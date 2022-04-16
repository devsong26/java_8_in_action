package chapter4;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example {

    public static void main(String[] args){
//        List<String> title = Arrays.asList("a", "b", "c");
//        Stream<String> s = title.stream();
//        s.forEach(System.out::println);
//        s.forEach(System.out::println);

////        List<String> names = dishes.stream()
////                                    .filter(d -> d.getCalories() > 300)
////                                    .map(Dish::getName)
////                                    .limit(3)
////                                    .collect(Collectors.toList());
//
//        List<Dish> dishes =
//                menu.stream()
//                    .filter(d -> d.getType() == Dish.Type.MEAT)
//                    .limit(2)
//                    .collect(Collectors.toList());
//
//
//        List<Integer> dishNameLengths =
//                menu.stream()
//                        .map(Dish::getName)
//                        .map(String::length)
//                        .collect(Collectors.toList());

        List<String> words = Arrays.asList(new String[]{"Hello", "World"});
        List<String> uniqueChars =
                        words.stream()
                                .map(word -> word.split(""))
                                .flatMap(Arrays::stream)
                                .distinct()
                                .collect(Collectors.toList());

        uniqueChars.forEach(System.out::println);

        Arrays.asList(new Integer[]{1, 2, 3, 4, 5})
                .stream()
                .map(e -> e * e)
                .collect(Collectors.toList());

        List<Integer> param1 = Arrays.asList(1, 2, 3);
        List<Integer> param2 = Arrays.asList(3, 4);

        List<int[]> lst =
        param1.stream()
                .flatMap(e1 ->
                    param2.stream()
                            .filter(e2 -> (e2 + e1) % 3 == 0)
                            .map(e2 -> new int[]{e1, e2})
                )
                .collect(Collectors.toList());

        for(int[] i : lst){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

        List<Dish> menu = new ArrayList<>();
//        Optional<Dish> dish =
               menu.stream()
                   .filter(Dish::isVegetarian)
                   .findAny()
                   .ifPresent(d -> System.out.println(d.getName()));


       int sum = Arrays.asList(1,2,3)
                        .stream()
                        .reduce(0, Integer::sum);

       menu.stream()
           .map(d -> 1)
           .reduce(0, Integer::sum);

       menu.stream()
               .mapToInt(Dish::getCalories)
               .sum();

        OptionalInt maxCal = menu.stream().mapToInt(Dish::getCalories).max();

        Stream<int[]> pythagoraeanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                        .mapToObj(b ->
                                                new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                        );

        Stream<double[]> pythagoraeanTriples2 =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .mapToObj(b ->
                                                new double[]{a, b, Math.sqrt(a * a + b * b)})
                                        .filter(t -> t[2] % 1 == 0));

//        long uniqueWords = 0;
//        try(Stream<String> lines =
//                Files.lines(Paths.get(".txt"), Charset.defaultCharset())){
//            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
//                    .distinct()
//                    .count();
//        }catch (IOException e){
//
//        }
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        Stream.iterate(new int[]{0, 1}, e -> new int[]{e[1], e[0] + e[1]})
                .limit(20)
                .forEach(e ->
                    System.out.println("(" + e[0] + ", " + e[1] + ")"));
    }

}
