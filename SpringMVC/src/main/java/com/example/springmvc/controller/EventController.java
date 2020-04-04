package com.example.springmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebResult;
import javax.print.attribute.standard.Media;
import java.util.Locale;
import java.util.TimeZone;

@RestController
public class EventController {

    @GetMapping("/events")
    public String events2(Locale locale, TimeZone timeZone){

        return "events -> ";
    }

    @GetMapping("/events/{id}")
    public String events3(@PathVariable String id){
        return "events -> " + id;
    }

    @PostMapping(value = "/events", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String events4(){
        return "";
    }

}
