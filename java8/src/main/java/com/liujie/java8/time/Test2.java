package com.liujie.java8.time;

import org.junit.Test;

import java.time.*;

public class Test2 {

    @Test
    public void test1(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime of = LocalDateTime.of(2018, 3, 8, 15, 55, 55);
        System.out.println(of);
        LocalDateTime localDateTime = now.plusYears(1);
        System.out.println(localDateTime);
        System.out.println(now.minusMonths(1));
        System.out.println(now.getYear());
        System.out.println(now.getMonth());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
    }

    @Test
    public void test2(){
        Instant now = Instant.now();
        System.out.println(now);

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        System.out.println(now.toEpochMilli());
        System.out.println(System.currentTimeMillis());
//        now.atZone(ZoneId.)
    }

    @Test
    public void test3() throws InterruptedException {

        Instant now = Instant.now();
        Thread.sleep(500);
        Instant now1 = Instant.now();
        System.out.println(Duration.between(now,now1).toMillis());

        LocalTime now2 = LocalTime.now();
        Thread.sleep(200);
        LocalTime now3 = LocalTime.now();
        System.out.println(Duration.between(now2,now3).toMillis());
    }
    @Test
    public void test4() {
        LocalDate now = LocalDate.now();
        LocalDate of = LocalDate.of(2018, 3, 4);
        System.out.println(Period.between(now,of));
    }

}
