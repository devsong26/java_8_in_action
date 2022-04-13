package chapter1;

import dto.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Example4 {

    public interface Predicate<T>{
        boolean test(T t);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e : list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args){
//        List<Apple> redApples =
//                filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
//
//        List<String> evenNumbers =
//                filter(numbers, (Integer i) -> i % 2 == 0);

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello world");
//            }
//        });

        Thread t = new Thread(() -> System.out.println("Hello world"));

        Runnable r = () -> {
            System.out.println("dd");
        };

        Supplier<Apple> c = Apple::new;

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);

        Function<Integer, Apple> c2 = Apple::new;
        Apple a2 = c2.apply(110);

        BiFunction<String, Integer, Apple> c3 = Apple::new;
        Apple a3 = c3.apply("green", 110);

        TriFunction<Integer, Integer, Integer, Apple> c4 = Apple::new;
        Apple a4 = c4.apply(1, 2, 3);

    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f){
        List<Apple> result = new ArrayList<>();
        for(Integer e : list){
            result.add(f.apply(e));
        }
        return result;
    }

    public interface TriFunction<T, U, V, R>{
        R apply(T t, U u, V v);
    }

}
