package com.pluralsight.controller;

import com.pluralsight.model.Attendee;
import com.pluralsight.model.Event;
import com.pluralsight.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping
public class AttendeeController {

    @RequestMapping(value = "/attendee", method = RequestMethod.GET)
    public String attendee(Model model){

        model.addAttribute(new Attendee());
        return "attendee";
    }

    @Autowired
    private AttendeeService attendeeService;

    @RequestMapping(value = "/attendee", method = RequestMethod.POST)
    public String attendee(@Valid @ModelAttribute Attendee attendee, BindingResult bindingResult, HttpSession session){

        if(bindingResult.hasErrors()){
            return "attendee";
        }

        Event event = (Event)session.getAttribute("event");
        attendeeService.addToEvent(attendee, event);
        return "redirect:index.html";
    }
}
