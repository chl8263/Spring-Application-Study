package me.ewan.ewan.bootApplication;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

//@Component
public class SimpleListener2 {

    public SimpleListener2(ApplicationArguments arguments){
        System.out.println("bar: " + arguments.containsOption("bar"));
    }
}