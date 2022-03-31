package chapter1;

import dto.Apple;
import formatter.AppleFormatter;
import predicate.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

public class Example3 {

    interface A{
        default String getText(){
            return "text";
        }
    }

    interface B extends A{

    }

    public static void main(String[] args){
        Runner runner = new Runner();
//        runner.setPredicate();
        runner.run();
    }

    private static class Runner{
        private ApplePredicate predicate;

        public Runner(){}

        public void setPredicate(ApplePredicate predicate) {
            this.predicate = predicate;
        }

        public void run(){

        }

        public List<Apple> filterApples(
                List<Apple> inventory,
                ApplePredicate predicate){
            List<Apple> result = new ArrayList<>();
            for(Apple apple : inventory){
                if(predicate.test(apple)){
                    result.add(apple);
                }
            }
            return result;
        }

        public void prettyPrintApple(List<Apple> inventory,
                                     AppleFormatter formatter){
            for(Apple apple : inventory){
                String output = formatter.accept(apple);
                System.out.println(output);
            }
        }
    }

}
