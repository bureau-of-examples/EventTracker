package com.pluralsight.validation;

import com.pluralsight.model.Event;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class ValidEventValidator implements ConstraintValidator<ValidEvent, Event> {
    @Override
    public void initialize(ValidEvent constraintAnnotation) {

    }

    @Override
    public boolean isValid(Event value, ConstraintValidatorContext context) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2005,1,1);
        Date demolishDate = calendar.getTime();
       if(Objects.equals("Building 39", value.getLocation()) && value.getDate() != null && !value.getDate().before(demolishDate))
           return false;
        return true;
    }
}
