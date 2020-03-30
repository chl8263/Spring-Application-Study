package com.example.springmvcprinciple.controller;

import com.example.springmvcprinciple.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/hello")
    //@GetMapping("/hello/{name}")
    //public String hello(@PathVariable("name") Person person){
    //public String hello(@RequestParam("name") Person person){
    public String hello(@RequestParam("id") Person person){
        return "hello " + person.getName();
    }
}
