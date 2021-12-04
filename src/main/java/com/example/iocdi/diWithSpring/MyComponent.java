package com.example.iocdi.diWithSpring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class MyComponent {

    final private GreetingService greetingService;

    // using a primary of implementations of GreetingService
    public MyComponent(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayHello();
    }
}
