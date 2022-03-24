package com.example.iocdi;

import com.example.iocdi.diWithSpring.controller.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
public class IocDiApplication {

    final private static Logger LOGGER = Logger.getLogger(IocDiApplication.class.getName());

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(IocDiApplication.class, args);
        // in case with circular dependency, BeanCurrentlyInCreationException -> UnsatisfiedDependencyException

        InternationalController i18nController = (InternationalController) applicationContext.getBean("internationalController");
        System.out.println(i18nController.getGreeting());

        MyController myController = (MyController) applicationContext.getBean("myController");
        System.out.println(myController.getGreeting());

        PropertyInjectedController propertyInjectedComponent = (PropertyInjectedController) applicationContext.getBean("propertyInjectedController");
        System.out.println(propertyInjectedComponent.getGreeting());

        SetterInjectedController setterInjectedComponent = (SetterInjectedController) applicationContext.getBean("setterInjectedController");
        System.out.println(setterInjectedComponent.getGreeting());

        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) applicationContext.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

    }

}
