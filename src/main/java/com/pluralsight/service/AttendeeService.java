package com.pluralsight.service;


import com.pluralsight.model.Attendee;
import com.pluralsight.model.Event;
import com.pluralsight.validation.group.BusinessLogicGroup;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

public interface AttendeeService {

    @Validated(BusinessLogicGroup.class)
    void addToEvent(Attendee attendee, @NotNull(message = "Event is not created. Please go back and create event first.") Event event);
}
