package chapter1;

import dto.Apple;

import java.util.ArrayList;
import java.util.List;

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
    }

}
