package com.liujie.java8.test;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test3 {
    public static void main(String[] args) {
        //消费性
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("我来了");

//        Optional<String,String> optional = (x,y) -> {return x+y;};
        //供给型
        Supplier<Long> supplier = () -> 234L;
        System.out.println(supplier.get());
        //运算行
        Function<Integer,Integer> function = (x) -> ++x;
        System.out.println(function.apply(10));
        //断言型
        Predicate<Employee> predicate = employee -> employee.getAge()>11;

        System.out.println(predicate.test(new Employee("掌声",10,123)));
    }
}
