package com.liujie.java8.test;

@FunctionalInterface
public interface MyFunc2<T,R> {
    T acpt(T t,R r);
}
