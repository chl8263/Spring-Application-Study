package com.example.springmvc.controller;

import com.example.springmvc.domain.Event;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebResult;
import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

@Controller
@SessionAttributes("event")
public class EventController {

    @GetMapping("/events/form/name")
    public String eventsFormName(Model model){
        Event event = new Event();
        model.addAttribute("event", event);
        return "events/form-name";
    }

    @GetMapping("/events/form")
    public String eventsForm(Model model, @SessionAttribute LocalDateTime visitTime){
        Event event = new Event();
        model.addAttribute("event", event);
        model.addAttribute("visitTime", visitTime);
        System.out.println(visitTime);
        return "events/form";
    }

    @GetMapping("/events/form/redirect")
    public String eventsFormRedirect(RedirectAttributes redirectAttributes, @SessionAttribute LocalDateTime visitTime){
        Event event = new Event();
        redirectAttributes.addAttribute("name", "ewan");
        redirectAttributes.addAttribute("visitTime", visitTime);
        System.out.println(visitTime);
        return "redirect:/events/form";
    }

    @PostMapping("/eventss")
    //public Event eventss(@RequestParam(required = false, defaultValue = "ewan") String name, @RequestParam Integer age){
    public String createEvent(@Validated @ModelAttribute Event event, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "events/form";
        }

        List<Event> eventList = new ArrayList<>();
        eventList.add(event);
        model.addAttribute("eventList", eventList);

        return "events/list";
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
