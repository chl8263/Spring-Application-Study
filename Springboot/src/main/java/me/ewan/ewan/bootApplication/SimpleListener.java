package me.ewan.ewan.bootApplication;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//@Component
public class SimpleListener implements ApplicationListener<ApplicationStartedEvent> {

//    @Override
//    public void onApplicationEvent(ApplicationStartingEvent event) {
//        System.out.println("=======================");
//        System.out.println("Application is starting");
//        System.out.println("=======================");
//    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("=======================");
        System.out.println("Application is started");
        System.out.println("=======================");
    }
}
