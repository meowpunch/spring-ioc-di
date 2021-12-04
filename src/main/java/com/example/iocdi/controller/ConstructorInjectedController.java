package com.example.iocdi.controller;

import com.example.iocdi.service.GreetingService;

public class ConstructorInjectedController {

    final private GreetingService greetingService;

    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayHello();
    }
}
