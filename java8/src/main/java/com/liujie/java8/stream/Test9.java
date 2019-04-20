package com.liujie.java8.stream;

import java.util.concurrent.RecursiveTask;

public class Test9 extends RecursiveTask<Long>{
    private long start;
    private long end;
    private static  final long  LIN = 10000L;
    @Override
    protected Long compute() {
        long length = end - start;
        if (length<=LIN){
            long sum = 0L;
            for (long i=start;i<=end;i++){
                sum += i;
            }
            return sum;
        }else {
            long midle = (end + start) / 2;
            Test9 left = new Test9(start, midle);
            left.fork();
            Test9 right = new Test9(midle + 1, end);
            right.fork();
            return left.join() + right.join();
        }
    }

    public Test9(long start, long end) {
        this.start = start;
        this.end = end;
    }
}
