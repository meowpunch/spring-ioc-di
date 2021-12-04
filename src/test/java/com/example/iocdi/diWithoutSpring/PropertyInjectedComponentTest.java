package com.example.iocdi.diWithoutSpring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyInjectedComponentTest {

    private PropertyInjectedComponent propertyInjectedComponent;

    @BeforeEach
    void setUp() {
        propertyInjectedComponent = new PropertyInjectedComponent();
        propertyInjectedComponent.greetingService = new GreetingServiceImpl();
    }

    @Test
    void getGreeting() {
        assertEquals("hello world", propertyInjectedComponent.getGreeting());
    }
}