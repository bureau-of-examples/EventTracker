package com.pluralsight.controller;

import com.pluralsight.model.Event;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.ValidatorFactory;

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


    @Resource(name = "mvcValidator")
    private SpringValidatorAdapter mvcValidator;

//    @Autowired
//    private ApplicationContext applicationContext;

    @RequestMapping(value="/event", method = RequestMethod.POST)
    public String displayEvent(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult){

        if(!bindingResult.hasErrors()){
            ValidationUtils.invokeValidator(mvcValidator, event, bindingResult, BusinessLogicGroup.class);
        }

        if(bindingResult.hasErrors()){
            return "event";
        }
        return "redirect:index.html";
    }
}
