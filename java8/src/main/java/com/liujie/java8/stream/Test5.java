package com.liujie.java8.stream;

import com.liujie.java8.test.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Test5 {

    public static void main(String[] args) {
        Supplier<List<Employee>> supplier = new Test5()::getEmployees;
        List<Employee> list = supplier.get();
//        boolean b = list.stream().allMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
//        boolean b = list.stream().anyMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
//        boolean b = list.stream().noneMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
//        System.out.println(b);
//        System.out.println("===================");
//        Optional<Employee> employee = list.stream().sorted((e1, e2) -> -Double.compare(e1.getSal(), e2.getSal()))
//                .findFirst();
//        System.out.println(employee.get());
        System.out.println("===================");
        Optional<Employee> any = list.parallelStream().filter(e -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(any.get());
        System.out.println("===================");
        long count = list.stream().count();
        System.out.println(count);
        System.out.println(list.size());

        System.out.println("===================");
        Optional<Employee> optional = list.parallelStream().max((e1, e2) -> Double.compare(e1.getAge(), e2.getAge()));
        System.out.println(optional.get());

        System.out.println("===================");
        Optional<Double> aDouble = list.stream().map(e -> e.getSal())
                .min(Double::compare);
//                .min((e1, e2) -> Double.compare(e1, e2));
//                max((e1, e2) -> Double.compare(e1.getAge(), e2.getAge()));
        System.out.println(aDouble.get());

        System.out.println("===================");
        Optional<Double> first = list.stream().sorted((e1, e2) -> -Double.compare(e1.getSal(), e2.getSal()))
                .map(e -> e.getSal())
                .findFirst();
        System.out.println(first.get());
        System.out.println("===================");
        Optional<Double> min = list.stream().map(e -> e.getSal())
                .min((e1, e2) -> -Double.compare(e1, e2));
//                .min(e->e);
        System.out.println(min.get());

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
