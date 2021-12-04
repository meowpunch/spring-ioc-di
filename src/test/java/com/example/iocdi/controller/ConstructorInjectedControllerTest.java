package com.example.iocdi.controller;

import com.example.iocdi.service.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorInjectedControllerTest {

    ConstructorInjectedController constructorInjectedController;

    @BeforeEach
    void setUp() {
        constructorInjectedController = new ConstructorInjectedController(new GreetingServiceImpl() );
    }

    @Test
    void getGreeting() {
        assertEquals("hello world", constructorInjectedController.getGreeting());
    }
}