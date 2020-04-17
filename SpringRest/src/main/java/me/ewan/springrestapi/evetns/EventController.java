package me.ewan.springrestapi.evetns;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.*;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.net.URI;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Controller
@RequestMapping(value = "/api/events", produces = MediaTypes.HAL_JSON_VALUE)
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    EventValidator eventValidator;

    @PostMapping
    public ResponseEntity createEvent(@RequestBody @Valid EventDto eventDto, Errors errors){

        System.out.println("");

        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors);//.build();
        }

        eventValidator.validate(eventDto, errors);
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors);//.build();
        }

        Event event = modelMapper.map(eventDto, Event.class);
        event.update();
        Event newEvent = this.eventRepository.save(event);
        WebMvcLinkBuilder webMvcLinkBuilder = linkTo(EventController.class).slash(newEvent.getId());
        URI createdUri = webMvcLinkBuilder.toUri();
        //event.setId(10);
        EventResource eventResource = new EventResource(event);
        eventResource.add(linkTo(EventController.class).withRel("query-events"));
        //eventResource.add(webMvcLinkBuilder.withSelfRel());
        eventResource.add(webMvcLinkBuilder.withRel("update-events"));
        return ResponseEntity.created(createdUri).body(eventResource);
    }

    @GetMapping
    public ResponseEntity queryEvents(Pageable pageable, PagedResourcesAssembler<Event> assembler){
        Page<Event> page = this.eventRepository.findAll(pageable);
        PagedModel<RepresentationModel<?>> entityModels = assembler.toModel(page, e -> new EventResource(e));
        entityModels.add(new Link("/docs/index.html#resource-events-list").withRel("profile"));
        entityModels.add(new Link("/docs/index.html#resource-events-list").withRel("profile"));

        return ResponseEntity.ok(entityModels);//(this.eventRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity getEvent(@PathVariable Long id){
        Optional<Event> optionalEvent = this.eventRepository.findById(id);
        if(!optionalEvent.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Event event = optionalEvent.get();
        EventResource eventResource = new EventResource(event);

        eventResource.add(new Link("/docs/index.html#resource-events-list").withRel("profile"));

        return ResponseEntity.ok(eventResource);
    }

    @PutMapping
    public ResponseEntity updateEvent(@PathVariable Long id, @RequestBody @Valid EventDto eventDto, Errors errors){

        Optional<Event> eventOptional = eventRepository.findById(id);

        if(!eventOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }

        if(errors.hasErrors()){
            return ResponseEntity.badRequest().build();
        }

        this.eventValidator.validate(eventDto, errors);
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().build();
        }

        Event existEvent = eventOptional.get();
        this.modelMapper.map(eventDto, existEvent);

        Event updatedEvent = eventRepository.save(existEvent);

        EventResource eventResource = new EventResource(updatedEvent);
        eventResource.add(new Link("/docs/index.html#resource-events-list").withRel("profile"));

        return ResponseEntity.ok(eventResource);
    }
}
