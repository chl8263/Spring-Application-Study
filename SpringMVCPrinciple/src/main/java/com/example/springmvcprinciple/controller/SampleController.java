package com.example.springmvcprinciple.controller;

import com.example.springmvcprinciple.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    @GetMapping("/hello")
    //@GetMapping("/hello/{name}")
    //public String hello(@PathVariable("name") Person person){
    //public String hello(@RequestParam("name") Person person){
    public String hello(@RequestParam("id") Person person){
        return "hello " + person.getName();
    }

    @GetMapping("/message")
    public @ResponseBody String message(@RequestBody Person person){
        return "hello person";
    }
}
