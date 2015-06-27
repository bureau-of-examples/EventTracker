package com.pluralsight.service;

import com.pluralsight.model.Attendee;
import com.pluralsight.model.Event;
import org.springframework.stereotype.Service;

@Service("attendeeService")
public class AttendeeServiceImpl implements AttendeeService {

    @Override
    public void addToEvent(Attendee attendee, Event event) {
        event.getAttendees().add(attendee);
    }
}
