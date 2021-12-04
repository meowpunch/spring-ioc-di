package com.example.iocdi.diWithSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedComponent {

    @Autowired
    /*
        A private field was only access and modified in class itself.
        But, Spring will use `reflection` to inject the dependency into the property.
     */
    private GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayHello();
    }
}
