package com.liujie.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test7 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> collect = list.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println(collect);
        Optional<Integer> reduce = list.stream().map(i -> 1).reduce(Integer::sum);
        System.out.println(reduce);

    }
}
