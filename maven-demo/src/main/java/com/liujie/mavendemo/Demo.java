package com.liujie.mavendemo;

import org.springframework.stereotype.Component;

@Component
public class Demo {

    public void demo(String name){
        System.out.println("Hello"+name);
    }
}
