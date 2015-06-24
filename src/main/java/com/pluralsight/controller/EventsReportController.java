package com.pluralsight.controller;

import com.pluralsight.model.Attendee;
import com.pluralsight.model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping
@SessionAttributes("event")
public class EventsReportController {

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public @ResponseBody List<Event> getEvents(@ModelAttribute("event") Event event){
        List<Event> result = new ArrayList<>();
        Event fake1 = new Event();
        fake1.setName("Fake event 1");
        fake1.getAttendees().add(new Attendee("fake attendee 1", "fake1@event.com"));
        fake1.getAttendees().add(new Attendee("fake attendee 2", "fake2@event.com"));
        result.add(fake1);

        result.add(event);
        return result;
    }
}
