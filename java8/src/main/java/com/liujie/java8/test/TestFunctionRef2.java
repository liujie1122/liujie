package com.liujie.java8.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestFunctionRef2 {
    public static void main(String[] args) {
        Function<String,String> function = x -> x.toUpperCase();
        String s = function.apply("asdSADa我sds是wdASDSsdasSfDSsadffe");
        System.out.println(s);

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
