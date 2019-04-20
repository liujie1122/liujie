package com.liujie.java8.test;

public class Test2 {
    public static void main(String[] args) {
        MyFunc1<String> myFunc = x -> x.trim();
        System.out.println(myFunc.acpt("  我的前后有空格   "));

        MyFunc1<String> myFunc1 = x -> x.toUpperCase();
        System.out.println(myFunc1.acpt("asfdOUsadAJJSADaas"));

        MyFunc1<String> myFunc2 = x -> x.substring(1,5);
        System.out.println(myFunc2.acpt("12345678910"));
        MyFunc2<Long,Long> myFunc21 = (x,y) -> {
            x++;
            return x+y;
        };
        System.out.println(myFunc21.acpt(12L,12L));

    }
}
