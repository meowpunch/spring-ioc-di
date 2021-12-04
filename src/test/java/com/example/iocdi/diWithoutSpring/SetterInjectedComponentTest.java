package com.example.iocdi.diWithoutSpring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetterInjectedComponentTest {

    SetterInjectedComponent setterInjectedComponent;

    @BeforeEach
    void setUp() {
        setterInjectedComponent = new SetterInjectedComponent();
        setterInjectedComponent.setGreetingService(new GreetingServiceImpl());
    }

    @Test
    void getGreeting() {
        assertEquals("hello world", setterInjectedComponent.getGreeting());
    }
}