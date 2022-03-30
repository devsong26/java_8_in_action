package chapter1;

import java.io.File;
import java.io.FileFilter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static chapter1.Example1.Apple;
import static java.util.stream.Collectors.groupingBy;

public class Example2 {

    public static void main(String[] args){
        // java 8 이전 버전
//        File[] hiddenFiles = new File(".").listFiles(new FileFilter(){
//            public boolean accept(File file){
//                return file.isHidden(); // 숨겨진 파일 필터링
//            }
//        });

        List<Apple> inventory = Arrays.asList(new Apple[]{
                new Apple(149, "red"), new Apple(150, "green")
        });

        // java 8
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        filterApples(inventory, Apple::isGreenApple);
        filterApples(inventory, Apple::isHeavyApple);

        filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        filterApples(inventory, (Apple a) -> a.getWeight() < 80 ||
                "brown".equals(a.getColor()));

//        Map<Currency, List<Transaction>> transactionsByCurrencies =
//                new HashMap<>();
//        for(Transaction transaction : transactions){
//            if(transaction.getPrice() > 1000){
//                Currency currency = transaction.getCurrency();
//                List<Transaction> transactionsForCurrency =
//                        transactionsByCurrencies.get(currency);
//                if(transactionsForCurrency == null){
//                    transactionsForCurrency = new ArrayList<>();
//                    transactionsByCurrencies.put(currency, transactionsForCurrency);
//                }
//                transactionsForCurrency.add(transaction);
//            }
//        }
//        List transactions = new ArrayList();
//        Map<Currency, List<Transaction>> transactionsByCurrencies =
//                transactions.stream()
//                        .filter((Transaction t) -> t.getPrice() > 1000)
//                        .collect(groupingBy(Transaction::getCurrency));
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if(apple.getWeight() > 150){
                result.add(apple);
            }
        }
        return result;
    }

    public interface Predicate<T>{
        boolean test(T t);
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if (p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

}
