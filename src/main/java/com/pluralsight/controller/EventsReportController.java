package com.pluralsight.controller;

import com.pluralsight.model.Event;
import com.pluralsight.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class EventsReportController {

    @Autowired
    private EventService eventService;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Event> getEvents() {

        return eventService.getAll();

    }
}
