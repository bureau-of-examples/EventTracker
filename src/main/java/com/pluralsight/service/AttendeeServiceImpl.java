package com.pluralsight.service;

import com.pluralsight.data.EventRepository;
import com.pluralsight.model.Attendee;
import com.pluralsight.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("attendeeService")
public class AttendeeServiceImpl implements AttendeeService {

    @Autowired
    private EventRepository eventRepository;

    @Transactional
    @Override
    public void addToEvent(Attendee attendee, Event event) {

        event = eventRepository.findOne(event.getId());   //load managed instance
        event.getAttendees().add(attendee);
    }
}
