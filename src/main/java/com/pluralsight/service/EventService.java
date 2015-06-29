package com.pluralsight.service;


import com.pluralsight.model.Event;

import java.util.List;

public interface EventService {

    Event createNew();

    Event getCurrent();

    void setCurrent(long eventId);

    void saveEvent(Event event);

    void deleteEvent(long eventId);

    List<Event> getAll();

}
