package com.example.iocdi.service;

import org.springframework.stereotype.Service;

@Service
public class WorldService {

    final private HelloService helloService;

    public WorldService(HelloService helloService) {
        this.helloService = helloService;
    }

    public String world() {
        return helloService.hello() + "world";
    }
}
