package me.ewan.springrestapi;


import me.ewan.springrestapi.evetns.Event;
import org.junit.jupiter.api.Test;

public class EventTest {

    @Test
    public void builder(){
        Event event = Event.builder().build();
    }
}
