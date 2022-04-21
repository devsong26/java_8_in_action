package chapter6;

import chapter4.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Example {

    public static void main(String[] args) {
        List<Dish> menu = new ArrayList<>();

        long howManyDishes = menu.stream().collect(Collectors.counting());
        long howManyDishes2 = menu.stream().count();

        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparing(Dish::getCalories);

        Optional<Dish> mostCalorieDish =
                menu.stream().collect(maxBy(dishCaloriesComparator));

        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

        menu.stream().collect(averagingInt(Dish::getCalories));

        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        List<Integer> numbers = stream.reduce(
                                    new ArrayList<Integer>(),
                                    (List<Integer> l, Integer e) -> {
                                        l.add(e);
                                        return l;
                                    },
                                    (List<Integer> l1, List<Integer> l2) -> {
                                        l1.addAll(l2);
                                        return l1;
                                    });

        int totalCalories2 = menu.stream().collect(reducing(0,
                    Dish::getCalories, Integer::sum
                ));

//        int totalCalories3 = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
//        int totalCalories4 = menu.stream().mapToInt(Dish::getCalories).sum();

//        String shortMenu = menu.stream().map(Dish::getName).collect(reducing((s1, s2) -> s1 + s2)).get();
//        System.out.println(shortMenu);

        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(dish -> {
                    if(dish.getCalories() <= 400){
                        return CaloricLevel.DIET;
                    }else if(dish.getCalories() <= 700){
                        return CaloricLevel.NORMAL;
                    }else{
                        return CaloricLevel.FAT;
                    }
                }));

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType, groupingBy(dish -> {
                            if(dish.getCalories() <= 400){
                                return CaloricLevel.DIET;
                            }else if(dish.getCalories() <= 700){
                                return CaloricLevel.NORMAL;
                            }else{
                                return CaloricLevel.FAT;
                            }
                        }))
                );

        Map<Dish.Type, Optional<Dish>> mostCaloriesByType =
                menu.stream().collect(groupingBy(Dish::getType,
                        maxBy(Comparator.comparing(Dish::getCalories))));

        Map<Dish.Type, Dish> mostCaloriesByType2 =
                menu.stream().collect(groupingBy(Dish::getType,
                        collectingAndThen(
                                maxBy(Comparator.comparing(Dish::getCalories)),
                        Optional::get)));

        Map<Dish.Type, Integer> t = menu.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(groupingBy(Dish::getType, mapping(dish -> {
                    if(dish.getCalories() <= 400){
                        return CaloricLevel.DIET;
                    }else if(dish.getCalories() <= 700){
                        return CaloricLevel.NORMAL;
                    }else{
                        return CaloricLevel.FAT;
                    }
                }, toSet())));

        Map<Dish.Type, Set<CaloricLevel>> t2 =
                menu.stream().collect(groupingBy(Dish::getType, mapping(dish -> {
                    if(dish.getCalories() <= 400){
                        return CaloricLevel.DIET;
                    }else if(dish.getCalories() <= 700){
                        return CaloricLevel.NORMAL;
                    }else{
                        return CaloricLevel.FAT;
                    }
                }, toCollection(HashSet::new))));
    }

    enum CaloricLevel{DIET, NORMAL, FAT}

}
