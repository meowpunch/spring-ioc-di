package com.example.iocdi.diWithoutSpring;

public class PropertyInjectedComponent {

    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayHello();
    }
}
