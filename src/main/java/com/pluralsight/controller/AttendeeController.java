package com.pluralsight.controller;

import com.pluralsight.model.Attendee;
import com.pluralsight.model.Event;
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

    @RequestMapping(value = "/attendee", method = RequestMethod.POST)
    public String attendee(@Valid @ModelAttribute Attendee attendee, BindingResult bindingResult, HttpSession session){

        Event event = (Event)session.getAttribute("event");
        if(event == null){
            throw new RuntimeException("Event is not created yet.");
        }

        if(bindingResult.hasErrors()){
            return "attendee";
        }
        
        event.getAttendees().add(attendee);
        return "redirect:index";
    }
}
