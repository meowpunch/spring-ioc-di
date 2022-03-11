package com.example.iocdi.diWithSpring.controller;

import com.example.iocdi.diWithSpring.service.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    final private GreetingService greetingService;

    // using a primary of implementations of GreetingService
    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayHello();
    }
}
