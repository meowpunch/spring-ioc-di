package com.example.iocdi.diWithSpring.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Profile("EN")
@Service("i18nService")
public class EnglishGreetingService implements GreetingService {
    @Override
    public String sayHello() {
        return "Hello - EN";
    }
}
