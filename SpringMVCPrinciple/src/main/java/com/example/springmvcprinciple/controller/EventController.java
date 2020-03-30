package com.example.springmvcprinciple.controller;

import com.example.springmvcprinciple.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    //@Autowired
    private EventService service;

    //@RequestMapping(value = "/events", method = RequestMethod.GET)
    @GetMapping("/event")
    public String events(Model model){

        model.addAttribute("events", service.getEvents());
        return "events";
    }
}
