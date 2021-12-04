package com.example.iocdi.diWithoutSpring;

public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHello() {
        return "hello world";
    }
}
