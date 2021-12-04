package com.example.iocdi.diWithSpring;

import org.springframework.stereotype.Service;

@Service
public class PropertyGreetingService implements GreetingService {
    @Override
    public String sayHello() {
        return "hello property";
    }
}
