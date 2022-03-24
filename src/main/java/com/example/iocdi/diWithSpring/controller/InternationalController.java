package com.example.iocdi.diWithSpring.controller;

import com.example.iocdi.diWithSpring.service.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class InternationalController {

    final private GreetingService greetingService;

    public InternationalController(@Qualifier("i18nService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayHello();
    }

}
