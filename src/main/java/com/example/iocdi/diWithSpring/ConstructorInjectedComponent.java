package com.example.iocdi.diWithSpring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedComponent {

    final private GreetingService greetingService;

    public ConstructorInjectedComponent(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayHello();
    }
}
