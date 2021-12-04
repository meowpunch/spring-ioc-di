package com.example.iocdi.diWithSpring;

import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedComponent {

    final private GreetingService greetingService;

    public ConstructorInjectedComponent(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayHello();
    }
}
