package me.ewan.ewan.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class SampleController {

    @Autowired
    SampleService sampleService;

    //@GetMapping("/hello")
    public String hello(){
        return sampleService.getName();
    }
}
