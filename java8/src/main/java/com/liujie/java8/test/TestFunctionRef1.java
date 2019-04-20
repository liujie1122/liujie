package com.liujie.java8.test;

import java.util.*;
import java.util.function.*;

public class TestFunctionRef1 {
    public static void main(String[] args) {
        Supplier<List<Employee>> supplier = new TestFunctionRef1()::getEmployees;
        List<Employee> employees = supplier.get();
        for (Employee employee:employees){
            System.out.println(employee);
        }
        System.out.println("=================");
        Comparator<Employee> comparator = (e1,e2) ->{
            if (e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        };
        Collections.sort(employees,comparator);
        for (Employee employee:employees){
            System.out.println(employee);
        }
    }
//    public List<Employee> sortEmployee(List<Employee> employees,){
//        List<Employee> list = new ArrayList<>();
//        for ()
//
//    }


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
