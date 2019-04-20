package com.liujie.java8.stream;

import com.liujie.java8.test.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Test3 {
    public static void main(String[] args) {
        Supplier<List<Employee>> supplier = new Test3()::getEmployees;
        List<Employee> employeeList = supplier.get();
        Stream<Employee> stream = employeeList.stream();

        Stream<Boolean> stream1 = stream.map(employee -> employee.getAge() > 15);
//        stream1.forEach(System.out::println);

//        employeeList.stream()
//                .map(e1 -> {
//                    if (e1.getAge()>15)
//                        return e1;
//                    return null;
//                }).limit(1)
//                .forEach(System.out::println);
        List<String> list =Arrays.asList("aa","bb","cc","dd");
        list.stream().map(str->str.toUpperCase())
                .forEach(System.out::println);
        System.out.println("====================");
        employeeList.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
        System.out.println("====================");

        list.stream()
                .map(Test3::filterCharacter)
                .forEach(s->{
                    s.forEach(System.out::println);
                });

        System.out.println("====================");

        Stream<Character> stream2 = list.stream()
                .flatMap(Test3::filterCharacter);

        stream2.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String s){
        ArrayList<Character> list = new ArrayList<>();
        for (Character char1:s.toCharArray()) {
            list.add(char1);
        }
        return list.stream();
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
