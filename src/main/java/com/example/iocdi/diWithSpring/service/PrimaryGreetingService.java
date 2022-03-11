package com.example.iocdi.diWithSpring.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class PrimaryGreetingService implements GreetingService {
    @Override
    public String sayHello() {
        return "hello world";
    }
}
