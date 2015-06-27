package com.pluralsight.controller;

import com.pluralsight.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping
@SessionAttributes("event")
public class EventController {

    @RequestMapping(value="/event", method = RequestMethod.GET)
    public String displayEvent(Model model, HttpSession session){

        Event event = (Event)session.getAttribute("event");
        if(event == null) {
            event = new Event();
            event.setId(1L);
            event.setName("Java User Group");
        }
        model.addAttribute("event", event);
        return "event";
    }

    @RequestMapping(value="/event", method = RequestMethod.POST)
    public String displayEvent(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "event";
        }
        return "redirect:index.html";
    }
}
