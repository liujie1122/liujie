package com.liujie.java8.stream;

import com.liujie.java8.test.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Test4 {

    public static void main(String[] args) {
        Supplier<List<Employee>> supplier = new Test4()::getEmployees;
        List<Employee> list = supplier.get();
        list.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("==================");
        list.stream()
                .sorted((e1,e2)->{
                    if (e1.getAge()==e2.getAge()){
                        return e1.getName().compareTo(e2.getName());
                    }else {
                        return -Integer.compare(e1.getAge(),e2.getAge());
                    }
                })
                .forEach(System.out::println);

//        list
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
