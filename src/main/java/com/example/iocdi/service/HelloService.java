package com.example.iocdi.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    final private WorldService worldService;

    HelloService(WorldService worldService) {
        this.worldService = worldService;
    }

    public String hello() {
        return "hello" + worldService.world();
    }
}
