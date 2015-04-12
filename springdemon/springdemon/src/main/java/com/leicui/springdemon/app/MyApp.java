package com.leicui.springdemon.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.leicui.springdemon.service.MyService;
import com.leicui.springdemon.springconfig.SpringConfig;

public class MyApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        ctx.scan("com.leicui.springdemon.service");
        MyService myService = ctx.getBean(MyService.class);
        myService.sayHello();
    }
}
