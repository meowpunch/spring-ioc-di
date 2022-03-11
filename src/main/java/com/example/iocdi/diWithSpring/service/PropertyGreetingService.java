package com.example.iocdi.diWithSpring.service;

import org.springframework.stereotype.Service;

@Service
public class  PropertyGreetingService implements GreetingService {
    @Override
    public String sayHello() {
        return "hello property";
    }
}
