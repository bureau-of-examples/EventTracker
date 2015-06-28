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
@SessionAttributes("event")
public class EventController {

    @Autowired
    private EventService eventService;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public String displayEvent(Model model, @RequestParam(value = "add", required = false) Boolean addNew, HttpSession session) {

        boolean add = Boolean.TRUE.equals(addNew);

        Event event = (Event) session.getAttribute("event");
        if (event == null || add) {

            if (add && event != null) { //this event goes to eventList in session.
                List<Event> eventList = (List<Event>) session.getAttribute("eventList");
                storeEvent(session, event, eventList);
            }

            event = eventService.create();
        }
        model.addAttribute("event", event);
        return "event";
    }

    private void storeEvent(HttpSession session, Event event, List<Event> eventList) {
        if (eventList == null) {
            eventList = Collections.synchronizedList(new ArrayList<Event>());
            session.setAttribute("eventList", eventList);
        }
        if (!eventList.contains(event))
            eventList.add(event);
    }


    @Resource(name = "mvcValidator")
    private SpringValidatorAdapter mvcValidator;

//    @Autowired
//    private ApplicationContext applicationContext;

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public String displayEvent(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            ValidationUtils.invokeValidator(mvcValidator, event, bindingResult, BusinessLogicGroup.class);
        }

        if (bindingResult.hasErrors()) {
            return "event";
        }
        return "redirect:index.html";
    }

    @RequestMapping(value = "/setCurrent", method = RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public String setCurrent(Model model, @RequestParam("eventId") int eventId, @ModelAttribute("event") Event event, HttpSession session) {

        if (event != null && event.getId() == eventId) {
            return "redirect:/";
        }

        List<Event> eventList = (List<Event>) session.getAttribute("eventList");
        if (eventList != null) {
            for (Event e : eventList) {
                if (e.getId() == eventId) {
                    storeEvent(session, event, eventList);
                    model.addAttribute("event", e);
                    return "redirect:/";
                }
            }
        }

        throw new RuntimeException("Event Id " + eventId + " is invalid.");
    }
}
