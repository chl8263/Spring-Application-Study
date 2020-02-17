package me.ewan.ewan.externalSetting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class ExternalSettingRunner implements ApplicationRunner {

//    @Value("${Ewan.name}")
//    private String name;
//
//    @Value("${Ewan.age}")
//    private String name2;

    @Autowired
    EwanProperties properties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("===================");
        System.out.println(properties.getName());
        System.out.println(properties.getAge());
        System.out.println("===================");
    }
}
