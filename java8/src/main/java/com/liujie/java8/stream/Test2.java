package com.liujie.java8.stream;

import com.liujie.java8.test.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {
        Supplier<List<Employee>> supplier = new Test2()::getEmployees;
        List<Employee> employeeList = supplier.get();
        Stream<Employee> stream = employeeList.stream();
        Stream<Employee> stream1 = stream.filter(e -> {
            System.out.println("我是中间操作--短路");
            return e.getAge() > 15;
        });

//        stream1.forEach(System.out::println);
//        stream1.limit(2).forEach(System.out::println);
//        stream1.skip(2).forEach(System.out::println);
        stream1.distinct().forEach(System.out::println);


    }


    public List<Employee> getEmployees(){
        return Arrays.asList(
                new Employee("李四",22,2222),
                new Employee("李四",22,2222),
                new Employee("麻子",44,4444),
                new Employee("麻子",44,4444),
                new Employee("子麻",44,4444),
                new Employee("张三",11,1111),
                new Employee("张三",11,1111),
                new Employee("三张",11,1111),
                new Employee("赵六",66,6666),
                new Employee("王二",33,3333),
                new Employee("二王",33,3333),
                new Employee("二王",33,3333),
                new Employee("王五",55,5555),
                new Employee("王五",55,5555)
        );
    }
}
