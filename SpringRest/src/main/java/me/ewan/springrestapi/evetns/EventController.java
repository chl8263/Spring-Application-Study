package me.ewan.springrestapi.evetns;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Controller
@RequestMapping(value = "/api/events", produces = MediaTypes.HAL_JSON_VALUE)
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity createEvent(@RequestBody EventDto eventDto){

        System.out.println(eventDto.getEndEventDateTime());

        Event event = modelMapper.map(eventDto, Event.class);

        System.out.println(event.getEndEventDateTime());


        Event newEvent = this.eventRepository.save(event);

        if(newEvent == null) System.out.println("sexxxxxxxxxxxxxxxxx");

        System.out.println(newEvent.getEndEventDateTime());

        System.out.println(newEvent.getId());
        URI createdUri = linkTo(EventController.class).slash(newEvent.getId()).toUri();
        //event.setId(10);
        return ResponseEntity.created(createdUri).body(event);
    }
}
