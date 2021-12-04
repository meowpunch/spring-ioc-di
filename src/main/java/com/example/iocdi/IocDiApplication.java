package com.example.iocdi;

import com.example.iocdi.diWithSpring.ConstructorInjectedComponent;
import com.example.iocdi.diWithSpring.MyComponent;
import com.example.iocdi.diWithSpring.PropertyInjectedComponent;
import com.example.iocdi.diWithSpring.SetterInjectedComponent;
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

        MyComponent myComponent = (MyComponent) applicationContext.getBean("myComponent");
        System.out.println(myComponent.getGreeting());

        PropertyInjectedComponent propertyInjectedComponent = (PropertyInjectedComponent) applicationContext.getBean("propertyInjectedComponent");
        System.out.println(propertyInjectedComponent.getGreeting());

        SetterInjectedComponent setterInjectedComponent = (SetterInjectedComponent) applicationContext.getBean("setterInjectedComponent");
        System.out.println(setterInjectedComponent.getGreeting());

        ConstructorInjectedComponent constructorInjectedComponent = (ConstructorInjectedComponent) applicationContext.getBean("constructorInjectedComponent");
        System.out.println(constructorInjectedComponent.getGreeting());

    }

}
