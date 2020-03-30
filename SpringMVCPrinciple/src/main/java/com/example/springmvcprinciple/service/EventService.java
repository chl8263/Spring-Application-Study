package com.example.springmvcprinciple.service;

import com.example.springmvcprinciple.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    public List<Event> getEvents(){
        Event event = new Event();
        event.setName("spring MVC");
        event.setLimitOfEnrollment(5);
        event.setStartDateTime(LocalDateTime.of(2019, 1, 10, 10, 0));
        event.setEndDateTime(LocalDateTime.of(2019, 1, 10, 20, 0));

        Event event1 = new Event();
        event1.setName("spring MVC 2");
        event1.setLimitOfEnrollment(5);
        event1.setStartDateTime(LocalDateTime.of(2019, 1, 17, 10, 0));
        event1.setEndDateTime(LocalDateTime.of(2019, 1, 17, 20, 0));

        List<Event> events = new ArrayList<>();
        events.add(event);
        events.add(event1);

        return events;
    }
}
