package com.example.iocdi.diWithSpring.service;

import org.springframework.stereotype.Service;


@Service
public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayHello() {
        return "hello constructor";
    }
}
