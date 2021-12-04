package com.example.iocdi.controller;

import com.example.iocdi.service.GreetingService;

public class SetterInjectedController {

    public GreetingService greetingService;

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayHello();
    }
}
