package com.liujie.java8.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        List<Employee> employees = test1.getEmployees();
        System.out.println(employees);
        System.out.println("===============");
        Collections.sort(employees,(e1,e2) -> {
            if (e1.getAge()== e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });

        System.out.println(employees);
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
