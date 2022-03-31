package com.example.iocdi.diWithSpring.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Profile({"KR", "default"})
@Service("i18nService")
public class KoreanGreetingService implements GreetingService {
    @Override
    public String sayHello() {
        return "안녕하세요 - KR";
    }
}
