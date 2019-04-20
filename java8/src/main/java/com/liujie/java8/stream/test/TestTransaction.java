package com.liujie.java8.stream.test;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestTransaction {
    List<Transaction> transactions = null;

    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        transactions = Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(mario, 2012, 950));
    }

    @Test
    public void test8() {
        //找到交易额最小的交易
        Stream<Transaction> sorted = transactions.stream().sorted((t1, t2) -> Double.compare(t1.getValue(), t2.getValue()));
        Optional<Transaction> first = sorted.findFirst();
        System.out.println(first.get());
    }

    @Test
    public void test7() {
        //所有交易中，最高的交易额是多少
        Optional<Integer> max = transactions.stream().map(t -> t.getValue()).max(Double::compare);
//        Stream<Integer> integerStream = transactions.stream().map(t -> t.getValue());
        Optional<Integer> reduce = transactions.stream().map(t -> t.getValue()).reduce((x1, x2) -> Integer.max(x1, x2));
        System.out.println(max.get());
        System.out.println(reduce.get());
    }
    @Test
    public void test6() {
        //打印生活在剑桥的交易员的所有交易额
        transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge"))
                .map(t->t.getValue())
                .forEach(System.out::println);

    }

    @Test
    public void test5() {
        //有没有交易员是在米兰工作的
        boolean milan = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(milan);
    }

    @Test
    public void test4() {
        //返回所有交易员的姓名字符串，按字母顺序排序。
        transactions.stream().map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted().forEach(System.out::println);

    }
    @Test
    public void test3() {
        //查找所有来自剑桥的交易员，并按姓名排序
        Stream<Transaction> cambridge = transactions.stream().
                filter(t -> t.getTrader().getCity().equals("Cambridge"));
        cambridge.sorted((t1,t2)->t1.getTrader().getName().compareTo(t2.getTrader().getName())).forEach(System.out::println);

    }

    @Test
    public void test2() {
        //交易员都在哪些不同的城市工作过
        transactions.stream().map(t->t.getTrader().getCity()).distinct().forEach(System.out::println);
    }
    @Test
    public void test1() {
        //找出2011年发生的所有交易，并按交易排序（从低到高）
        List<Transaction> collect = transactions.stream().filter(t -> t.getYear() == 2011)
                .sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue())).collect(Collectors.toList());
        System.out.println(collect);
        transactions.stream().filter(t -> t.getYear() == 2011)
                .sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue())).forEach(System.out::println);
    }


}