package com.liujie.java8.stream;

import com.liujie.java8.test.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test6 {

    public static void main(String[] args) {
        Supplier<List<Employee>> supplier = new Test6()::getEmployees;
        List<Employee> list = supplier.get();

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list1.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
        System.out.println("================");
        int sum2 =0;
        for (Integer integer:list1){
            sum2 += integer;
        }
        System.out.println(sum2);
        System.out.println("================");
        Optional<Double> optional = list.stream().map(Employee::getSal)
                .reduce((x, y) -> x + y);
        System.out.println(optional.get());
        System.out.println("================");

        List<String> collect = list.stream().map(Employee::getName)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);


        System.out.println("================");
        Set<String> collect1 = list.stream().map(Employee::getName)
                .collect(Collectors.toSet());
        collect1.forEach(System.out::println);

        System.out.println("================");
//        Set<String> collect1 = list.stream().map(Employee::getName)
//                .collect(Collectors.toSet());
//        collect1.forEach(System.out::println);
//        Optional<Double> reduce = list.stream().map(employee -> employee.getSal()).reduce((x, y) -> x + y);
//        System.out.println(reduce.get());
        Stream<String> stringStream = list.stream().map(employee -> employee.getName());

//        List<String> collect2 = stringStream.collect(Collectors.toList());
//        Set<String> collect3 = stringStream.collect(Collectors.toSet());
//        System.out.println(collect2);
//        System.out.println(collect3);
//
        Long collect2 = list.stream().collect(Collectors.counting());
        System.out.println(collect2);
        Double collect3 = list.stream().collect(Collectors.averagingDouble(Employee::getSal));
        System.out.println(collect3);
        Optional<Double> reduce = list.stream().map(Employee::getSal).reduce((x, y) -> x + y);
        Double collect4 = list.stream().collect(Collectors.summingDouble(Employee::getSal));
        Double collect5 = list.stream().collect(Collectors.summingDouble(e->e.getSal()));
        System.out.println(reduce.get());
        System.out.println(collect4);


        Optional<Employee> collect6 = list.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSal(), e2.getSal())));
        System.out.println(collect6.get());
        Optional<Double> collect7 = list.stream().map(Employee::getSal).collect(Collectors.minBy(Double::compare));
        Optional<Double> min = list.stream().map(Employee::getSal).min(Double::compare);
        Optional<Double> max = list.stream().map(Employee::getSal).max(Double::compare);
        System.out.println(collect7);
        System.out.println(min.get());
        System.out.println(max.get());

        Map<Employee.Status, List<Employee>> map = list.stream().collect(Collectors.groupingBy(employee -> employee.getStatus()));
        System.out.println(map);
        Map<Employee.Status, Map<String, List<Employee>>> mapMap = list.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
            if (e.getAge() <= 20) {
                return "少年";
            } else if (e.getAge() <= 30) {
                return "青年";
            } else {
                return "壮年";
            }
        })));
        System.out.println(mapMap);

        Map<Boolean, List<Employee>> collect8 = list.stream().collect(Collectors.partitioningBy(e -> e.getSal() >= 3000));
        System.out.println(collect8);
        DoubleSummaryStatistics collect9 = list.stream().collect(Collectors.summarizingDouble(Employee::getSal));
        System.out.println(collect9.getAverage());
        System.out.println(collect9);
    }


    public List<Employee> getEmployees(){
        return Arrays.asList(
                new Employee("李四",22,2222, Employee.Status.BUSY),
                new Employee("李四1",22,2222, Employee.Status.FREE),
                new Employee("麻子",44,4444, Employee.Status.VOCATION),
                new Employee("麻子",44,4444, Employee.Status.BUSY),
                new Employee("子麻",44,4444, Employee.Status.VOCATION),
                new Employee("张三",11,1111, Employee.Status.FREE),
                new Employee("张三",11,1111, Employee.Status.BUSY),
                new Employee("三张",11,1111, Employee.Status.FREE),
                new Employee("赵六",66,6666, Employee.Status.BUSY),
                new Employee("王二",33,3333, Employee.Status.VOCATION),
                new Employee("二王",33,3333, Employee.Status.VOCATION),
                new Employee("二王",33,3333, Employee.Status.FREE),
                new Employee("王五",55,5555, Employee.Status.BUSY),
                new Employee("王五",55,5555, Employee.Status.FREE)
        );
    }

}
