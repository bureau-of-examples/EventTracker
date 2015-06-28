package com.pluralsight.controller;

import com.pluralsight.model.Attendee;
import com.pluralsight.model.Event;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping
@SessionAttributes("event")
public class EventsReportController {

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Event> getEvents(@ModelAttribute("event") Event event, HttpSession session) {

        List<Event> result = new ArrayList<>();

        List<Event> eventList = (List<Event>) session.getAttribute("eventList");
        if (eventList != null) {
            result.addAll(eventList);
        }

        if (event != null && !result.contains(event)) {
            result.add(event);
        }

        return result;
    }
}
