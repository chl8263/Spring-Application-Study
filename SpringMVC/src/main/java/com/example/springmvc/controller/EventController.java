package com.example.springmvc.controller;

import com.example.springmvc.domain.Event;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebResult;
import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.util.Locale;
import java.util.TimeZone;

@Controller
public class EventController {

    @GetMapping("/events/form")
    public String eventsForm(Model model){
//        Event event = new Event();
//        model.addAttribute("event", event);

        return "events/form";
    }

    @PostMapping("/eventss")
    @ResponseBody
    //public Event eventss(@RequestParam(required = false, defaultValue = "ewan") String name, @RequestParam Integer age){
    public Event eventss(@Valid @ModelAttribute Event event, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            System.out.println("===========");
            bindingResult.getAllErrors().forEach(x -> {
                System.out.println(x.toString());
            });
        }

        return event;
    }

    @PostMapping("/event")
    @ResponseBody
    public Event events5(@RequestParam(required = false, defaultValue = "ewan") String name){

        Event event = new Event();
        event.setName(name);

        return event;
    }

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
