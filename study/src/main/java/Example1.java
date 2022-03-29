import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Example1 {

    public static void main(String[] args){
        List<Apple> inventory = Arrays.asList(new Apple[]{
                new Apple(1), new Apple(2)
        });

        // 자바 8 이전에 정렬 방식
        Collections.sort(inventory, new Comparator<Apple>(){
           public int compare(Apple a1, Apple a2){
               return a1.getWeight().compareTo(a2.getWeight());
           }
        });

        // 자바 8에 정렬 방식
        inventory.sort(Comparator.comparing(Apple::getWeight));
    }

    private static class Apple {
        private Integer weight;

        public Apple(Integer weight) {
            this.weight = weight;
        }

        public Integer getWeight() {
            return this.weight;
        }
    }
}
