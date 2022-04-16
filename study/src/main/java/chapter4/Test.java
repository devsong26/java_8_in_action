package chapter4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        exmaple1(transactionList);
        example2(transactionList);
        example3(transactionList);
        example4(transactionList);
        example5(transactionList);
        example6(transactionList);
        example7(transactionList);
        example8(transactionList);
    }

    private static void example8(List<Transaction> transactionList) {
        System.out.println("Example8");

        transactionList.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .ifPresent(System.out::println);

        System.out.println();
    }

    private static void example7(List<Transaction> transactionList) {
        System.out.println("Example7");

        transactionList.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .ifPresent(System.out::println);

        System.out.println();
    }

    private static void example6(List<Transaction> transactionList) {
        System.out.println("Example6");

        transactionList.stream()
                .filter(e -> e.getTrader().getCity().equals("Cambridge"))
                .forEach(System.out::println);

        System.out.println();
    }

    private static void example5(List<Transaction> transactionList) {
        System.out.println("Example5");

        transactionList.stream()
                .map(Transaction::getTrader)
                .filter(e -> e.getCity().equals("Milan"))
                .findAny()
                .ifPresent(e -> System.out.println(e));

        System.out.println();
    }

    private static void example4(List<Transaction> transactionList) {
        System.out.println("Example4");

        transactionList.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

        String res =
        transactionList.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .collect(Collectors.joining());

        System.out.println(res);

        System.out.println();
    }

    private static void example3(List<Transaction> transactionList) {
        System.out.println("Example3");

        transactionList.stream()
                .map(Transaction::getTrader)
                .filter(e -> e.getCity().equals("Cambridge"))
                .map(Trader::getName)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

        System.out.println();
    }

    private static void example2(List<Transaction> transactionList) {
        System.out.println("Example2");

        transactionList.stream()
                .map(e -> e.getTrader().getCity())
                .collect(Collectors.toSet());
//                .forEach(System.out::println);
//
//        System.out.println();
    }

    private static void exmaple1(List<Transaction> transactionList) {
        System.out.println("Example1");

        transactionList.stream()
                .filter(e -> e.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);

        System.out.println();
    }

}
