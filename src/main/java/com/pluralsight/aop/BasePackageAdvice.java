package com.pluralsight.aop;

import com.pluralsight.Constants;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class BasePackageAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder ){
        SimpleDateFormat format = new SimpleDateFormat(Constants.DATETIME_INPUT_FORMAT);
        format.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    @ModelAttribute
    public void addConstants(Model model){
        model.addAttribute("dateInputFormat", Constants.DATETIME_INPUT_FORMAT);
    }
}
