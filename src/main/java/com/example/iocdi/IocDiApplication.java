package com.example.iocdi;

import com.example.iocdi.service.HelloService;
import com.example.iocdi.service.WorldService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
public class IocDiApplication {

    final private static Logger LOGGER = Logger.getLogger(IocDiApplication.class.getName());

    public static void main(String[] args) {
        try {
            ApplicationContext applicationContext = SpringApplication.run(IocDiApplication.class, args);
            // BeanCurrentlyInCreationException -> UnsatisfiedDependencyException

            HelloService helloService = (HelloService) applicationContext.getBean("helloService");
            WorldService worldService = (WorldService) applicationContext.getBean("worldService");
            System.out.println(helloService.hello());
            System.out.println(worldService.world());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
