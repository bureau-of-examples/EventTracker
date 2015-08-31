package com.pluralsight.service;


import com.pluralsight.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service("eventService")
public class EventServiceImpl implements EventService {

    private long eventId = 1L;

    @Override
    public Event createNew() {
        Event event = new Event();
        event.setName("Default event");
        return event;
    }

    @Override
    public Event getCurrent() {
       return (Event)session.getAttribute("event");
    }

    @Autowired
    private HttpSession session;

    private final Object listLock = new Object();


    @Override
    public void setCurrent(long eventId) {

        synchronized (listLock){
            LinkedList<Event> eventList = getEventList();

            Iterator<Event> iterator = eventList.iterator();
            while (iterator.hasNext()){
                Event event = iterator.next();
                if(event.getId().equals(eventId)){
                    iterator.remove();
                    eventList.addLast(event);
                    session.setAttribute("event", event);
                    return;
                }
            }
        }

        throw new IllegalArgumentException("Event Id " + eventId + " is invalid.");
    }

    @SuppressWarnings("unchecked")
    private LinkedList<Event> getEventList() {
        LinkedList<Event> eventList = (LinkedList<Event>)session.getAttribute("eventList");
        if(eventList == null){
            eventList = new LinkedList<>();
            session.setAttribute("eventList", eventList);
        }
        return eventList;
    }

    @Override
    public void saveEvent(Event event) {

        synchronized (listLock){
            LinkedList<Event> eventList = getEventList();
            if(event.getId() == null){
                event.setId(eventId++);
                eventList.addLast(event);    //set new event as current
                session.setAttribute("event", event);
                return;
            }

            ListIterator<Event> iterator = eventList.listIterator();
            while (iterator.hasNext()){
                Event e = iterator.next();
                if(e.getId().equals(event.getId())){
                    event.setAttendees(e.getAttendees());
                    iterator.set(event);
                    session.setAttribute("event", event);
                    break;
                }
            }
        }
    }

    @Override
    public void deleteEvent(long eventId) {
        Event currentEvent = getCurrent();

        synchronized (listLock){
            LinkedList<Event> eventList = getEventList();

            Iterator<Event> iterator = eventList.iterator();
            while (iterator.hasNext()){
                Event event = iterator.next();
                if(event.getId().equals(eventId)){
                    iterator.remove();
                    if(currentEvent == event){
                        if(eventList.isEmpty()){
                            session.setAttribute("event", null);
                        } else {
                            session.setAttribute("event", eventList.getLast());
                        }
                    }
                    return;
                }
            }
        }

        throw new IllegalArgumentException("Event Id " + eventId + " is invalid.");
    }

    @Override
    public List<Event> getAll() {
        synchronized (listLock){
            LinkedList<Event> eventList = getEventList();
            return new ArrayList<>(eventList);
        }
    }
}
