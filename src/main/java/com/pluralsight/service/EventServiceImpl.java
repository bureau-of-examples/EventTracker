package com.pluralsight.service;


import com.pluralsight.model.Event;
import org.springframework.stereotype.Service;

@Service("eventService")
public class EventServiceImpl implements EventService {

    private long eventId = 1L;

    @Override
    public synchronized Event create() {
        Event event = new Event();
        event.setId(eventId++);
        event.setName("Default event");
        return event;
    }
}
