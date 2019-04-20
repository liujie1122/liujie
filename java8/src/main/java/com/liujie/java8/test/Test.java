package com.liujie.java8.test;

public class Test {
    public static void main(String[] args) {
        MyFunc myFunc = () -> System.out.println("我是无参狗爪");
        myFunc.acpt();

        MyFunc1<Integer> myFunc1 = (x) -> {return ++x;};
        System.out.println(myFunc1.acpt(100));
    }
}
