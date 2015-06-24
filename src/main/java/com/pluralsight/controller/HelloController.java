package com.pluralsight.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HelloController {

    @RequestMapping("/greeting")
    public String sayHello(Model model){

        model.addAttribute("greeting", "Hello world test.");

        return "hello";
    }

    @RequestMapping("/index")
    public String index(){
        return "forward:index.jsp";
    }
}
