package me.ewan.ewan.externalSetting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ExternalSettingRunner implements ApplicationRunner {

    //private Logger logger = LoggerFactory.getLogger(ExternalSettingRunner.class);

//    @Value("${Ewan.name}")
//    private String name;
//
//    @Value("${Ewan.age}")
//    private String name2;

    @Autowired
    EwanProperties properties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        logger.info("===================");
//        logger.info(properties.getName());
//        logger.info(properties.getAge());
//        logger.info(properties.getSessionTimeout().toString());
//        logger.info("===================");
    }
}
