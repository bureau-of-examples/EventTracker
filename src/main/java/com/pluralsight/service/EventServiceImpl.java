package com.pluralsight.service;


import com.pluralsight.data.EventRepository;
import com.pluralsight.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service("eventService")
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event createNew() {
        Event event = new Event();
        event.setName("Default event");
        return event;
    }

    @Autowired
    private HttpSession session;

    private static final String CURRENT_EVENT_ID_SESSION_KEY = "currentEventId";

    @Transactional
    @Override
    public Event getCurrent() {
        Long id = (Long)session.getAttribute(CURRENT_EVENT_ID_SESSION_KEY);
        if(id == null)
            return null;

        return eventRepository.findOne(id);
    }

    @Transactional
    @Override
    public void setCurrent(long eventId) {

        if(!eventRepository.exists(eventId))
            throw new IllegalArgumentException("Invalid event id " + eventId);

        session.setAttribute(CURRENT_EVENT_ID_SESSION_KEY, eventId);
    }

    @Transactional
    @Override
    public void saveEvent(Event event) {

        eventRepository.save(event);
        setCurrent(event.getId());
    }

    @Transactional
    @Override
    public void deleteEvent(long eventId) {
        eventRepository.delete(eventId);
        Long currentEventId = (Long)session.getAttribute(CURRENT_EVENT_ID_SESSION_KEY);
        if(currentEventId != null && currentEventId == eventId){
            session.removeAttribute(CURRENT_EVENT_ID_SESSION_KEY);
        }
    }

    @Transactional
    @Override
    public List<Event> getAll() {
        List<Event> list = new ArrayList<>();
        Iterable<Event> result = eventRepository.findAll();
        for(Event event : result){
            event.getAttendees().size();//force lazy loading
            list.add(event);
        }
        return list;
    }
}
