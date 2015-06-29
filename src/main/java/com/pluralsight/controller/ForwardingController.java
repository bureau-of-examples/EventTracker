package com.pluralsight.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ForwardingController {

    @RequestMapping("/greeting")
    public String sayHello(Model model){

        model.addAttribute("greeting", "Hello world test.");

        return "hello";
    }

    @RequestMapping("/index")
    public String index(){//put index page in mvc framework to utilise i18n support.
        return "index";
    }

}
