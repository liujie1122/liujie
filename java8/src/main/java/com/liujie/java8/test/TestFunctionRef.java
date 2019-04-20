package com.liujie.java8.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestFunctionRef {
    public static void main(String[] args) {

        Function<Integer,String[]> function1 = (size) -> new String[size];
        String[] apply = function1.apply(10);
        System.out.println(apply.length);

//        Function<Integer,List<String>> function1 = (size) -> new ArrayList<String>(size);
//        List<String> apply = function1.apply(1000);
//        apply.add("1000");
//        System.out.println(apply.size());

        BiPredicate<String,String> biPredicate = (t,u) -> t.equals(u);

        BiPredicate<String,String> biPredicate1 = String::equals;
        System.out.println(biPredicate1.test("x","y"));
        System.out.println(biPredicate1.test("x","x"));


        Consumer<String> consumer = (x) -> System.out.println(x);

//        PrintStream out = System.out;

        Consumer<String> consumer1 = System.out::println;
        consumer.accept("456");
        consumer1.accept("456");

        Supplier<String> supplier = () -> "我是被返回的";
        System.out.println(supplier.get());
        System.out.println("=================");
        Supplier<String> supplier1 = new TestFunctionRef() :: get;
        System.out.println(supplier1.get());

        Comparator<Integer> comparator = (x1,x2) -> Integer.compare(x1,x2);

        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println(comparator1.compare(12,15));

        Function<String,Integer> function = (x) -> x.compareTo(x+x);


    }

    public String get(){
        return "我也是啊";
    }

    public static String com(){
        return "我也是啊";
    }

}
