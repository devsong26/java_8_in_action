package chapter6;

import chapter4.Dish;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    }

}
