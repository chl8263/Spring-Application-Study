package com.example.springmvc.controller;

import com.example.springmvc.domain.Event;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventApi {

    @PostMapping
    public Event eventEvent(@Validated Event event, BindingResult bindingResult){
    //public Event eventEvent(HttpEntity<Event> request){
        // save event

        //MediaType mediaType = request.getHeaders().getContentType();
        //System.out.println(mediaType);

        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(x -> {
                System.out.println(x);
            });
        }

        return event;
    }
}
