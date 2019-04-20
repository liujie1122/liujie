package com.liujie.java8.stream;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;

public class Test8 {
    public static void main(String[] args) {
        long i = 5000000000L;
        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        Test9 test9 = new Test9(0,i);
        Long aLong = pool.invoke(test9);
        System.out.println(aLong);
        Instant end = Instant.now();
        System.out.println("fork join用时："+ Duration.between(start,end).toMillis());

        long sum = 0L;
        for (int j=0;j<=i;j++){
            sum += j;
        }
        System.out.println(sum);
        Instant now = Instant.now();
        System.out.println("单线程用时"+ Duration.between(end,now).toMillis());

    }
}
