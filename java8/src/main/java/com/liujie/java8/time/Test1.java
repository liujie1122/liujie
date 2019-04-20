package com.liujie.java8.time;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test1 {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");


        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return format.parse("20180308");
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> result = new ArrayList<>();
        for (int i = 0; i <100; i++) {
            result.add(pool.submit(task));
        }
//        for (Future<Date> future : result){
//            System.out.println(future.get());
//        }


    }

}
