package dto;

import chapter1.Example1;

public class Apple {
    private Integer weight;
    private String color;

    public Apple(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public String getColor() {
        return this.color;
    }

    public static boolean isGreenApple(Example1.Apple apple){
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Example1.Apple apple){
        return apple.getWeight() > 150;
    }


}