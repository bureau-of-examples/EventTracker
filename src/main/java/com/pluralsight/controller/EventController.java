package com.pluralsight.controller;

import com.pluralsight.model.Event;
import com.pluralsight.service.EventService;
import com.pluralsight.validation.group.BusinessLogicGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping
public class EventController {

    @Autowired
    private EventService eventService;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public String displayEvent(Model model, @RequestParam(value = "add", required = false) Boolean addNew) {

        boolean add = Boolean.TRUE.equals(addNew);
        Event event = eventService.getCurrent();
        if (event == null || add) {
            event = eventService.createNew();
        }
        model.addAttribute("event", event);
        return "event";
    }

    @Resource(name = "mvcValidator")
    private SpringValidatorAdapter mvcValidator;

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public String displayEvent(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            ValidationUtils.invokeValidator(mvcValidator, event, bindingResult, BusinessLogicGroup.class);
        }

        if (bindingResult.hasErrors()) {
            return "event";
        }

        eventService.saveEvent(event);
        return "redirect:index.html";
    }

    @RequestMapping(value = "/setCurrent", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public String setCurrent(@RequestParam("eventId") int eventId) {

        eventService.setCurrent(eventId);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteEvent", method = RequestMethod.POST)
    public String deleteEvent(@RequestParam("eventId") int eventId) {
        eventService.deleteEvent(eventId);
        return "redirect:/";
    }

    @RequestMapping(value = "showEvents", method = RequestMethod.GET)
    public String showEvents(Model model) {
        Event currentEvent = eventService.getCurrent();
        Long currentEventId;
        if(currentEvent == null){
          currentEventId = 0L;
        } else {
            currentEventId = currentEvent.getId();
        }

        model.addAttribute("currentEventId", currentEventId);
        return "showEvents";
    }

}
