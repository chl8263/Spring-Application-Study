package com.example.springmvc.controller;

import com.example.springmvc.annotation.GetHelloMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class SampleController {

    //@RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.PUT})
    //@GetMapping
    @RequestMapping({"/hello" , "hi"})
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping("/hello/*")
    @ResponseBody
    public String hello2(){
        return "hello";
    }

    @RequestMapping("/hello/**")
    @ResponseBody
    public String hello3(){
        return "hello";
    }

    @RequestMapping(value = "/hello/", consumes = MediaType.APPLICATION_JSON_VALUE, headers = HttpHeaders.ACCEPT)
    @ResponseBody
    public String hello4(){
        return "hello";
    }

    @GetHelloMapping
    @ResponseBody
    public String hello5(){
        return "hello111";
    }
}
