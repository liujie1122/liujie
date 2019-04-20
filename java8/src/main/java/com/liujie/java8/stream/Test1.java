package com.liujie.java8.stream;

import com.liujie.java8.test.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {
        //获取Stream对象的方法
        //1 一系列Collection对象的实例，调用stream()方法,得到串行流
        Supplier<List<Employee>> supplier = new Test1()::getEmployees;
        Stream<Employee> stream = supplier.get().stream();
        //2 一系列Collection对象的实例，调用stream()方法,得到并行流
        Stream<Employee> parallelStream = supplier.get().parallelStream();
        //3 直接通过Stream类的静态方法 of()
        Stream<String> of = Stream.of();
        //4 创建无限流
        //迭代
        Stream<Integer> iterate = Stream.iterate(0, x -> x+2);
//        iterate.limit(20).forEach(System.out::println);
        //生成
//        Supplier
        Stream<Integer> generate = Stream.generate(() ->(int)(Math.random()*100));
        generate.limit(10).forEach(System.out::println);


    }

    public List<Employee> getEmployees(){
        return Arrays.asList(
                new Employee("李四",22,2222),
                new Employee("麻子",44,4444),
                new Employee("子麻",44,4444),
                new Employee("张三",11,1111),
                new Employee("三张",11,1111),
                new Employee("赵六",66,6666),
                new Employee("王二",33,3333),
                new Employee("二王",33,3333),
                new Employee("王五",55,5555)
        );
    }
}
