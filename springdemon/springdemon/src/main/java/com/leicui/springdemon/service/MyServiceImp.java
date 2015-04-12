package com.leicui.springdemon.service;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImp implements MyService {

    public void sayHello() {
        System.out.println("Hello,I'm " + this.getClass());
    }

}
