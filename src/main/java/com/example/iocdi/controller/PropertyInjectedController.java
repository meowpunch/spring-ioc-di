package com.example.iocdi.controller;

import com.example.iocdi.service.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayHello();
    }
}
