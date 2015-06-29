package com.pluralsight.service;


import com.pluralsight.model.Event;

public interface EventService {

    Event createNew();

    Event getCurrent();

    void setCurrent(long eventId);

    void saveEvent(Event event);

    void deleteEvent(long eventId);

}
