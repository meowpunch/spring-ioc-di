package com.example.iocdi.diWithoutSpring;

public class ConstructorInjectedComponent {

    final private GreetingService greetingService;

    public ConstructorInjectedComponent(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayHello();
    }
}
