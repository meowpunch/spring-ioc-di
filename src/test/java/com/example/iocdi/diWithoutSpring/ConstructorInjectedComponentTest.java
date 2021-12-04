package com.example.iocdi.diWithoutSpring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorInjectedComponentTest {

    ConstructorInjectedComponent constructorInjectedComponent;

    @BeforeEach
    void setUp() {
        constructorInjectedComponent = new ConstructorInjectedComponent(new GreetingServiceImpl() );
    }

    @Test
    void getGreeting() {
        assertEquals("hello world", constructorInjectedComponent.getGreeting());
    }
}