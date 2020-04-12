package me.ewan.springrestapi;


import me.ewan.springrestapi.evetns.Event;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {

    @Test
    public void builder(){
        Event event = Event.builder()
                .name("Spring Rest API")
                .description("Rest API development with Spring")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean(){
        // Given
        String name = "Event";
        String description = "Spring";

        // When
        Event event = new Event();
        event.setName(name);
        event.setDescription(description);


        // Then
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);
    }

    @Test
    public void testFree(){
        //given
        Event event = Event.builder()
                .basePrice(0)
                .maxPrice(0)
                .build();

        //when
        event.update();

        //then
        assertThat(event.isFree()).isTrue();

        //given
        Event event2 = Event.builder()
                .basePrice(0)
                .maxPrice(100)
                .build();

        //when
        event2.update();

        //then
        assertThat(event2.isFree()).isFalse();

        //given
        Event event3 = Event.builder()
                .basePrice(100)
                .maxPrice(0)
                .build();

        //when
        event3.update();

        //then
        assertThat(event3.isFree()).isFalse();
    }

    @Test
    public void testOffline(){
        //given
        Event event = Event.builder()
                .location("Seattle")
                .build();

        //when
        event.update();

        //then
        assertThat(event.isOffline()).isTrue();

        //given
        Event event2 = Event.builder()
                .build();

        //when
        event2.update();

        //then
        assertThat(event2.isOffline()).isFalse();
    }
}