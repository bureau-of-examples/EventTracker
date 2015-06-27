package com.pluralsight.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class EventDurationValidator implements ConstraintValidator<EventDuration, Integer> {
    @Override
    public void initialize(EventDuration constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(value == null)
            return true;

        int val = value;
        return val > 0 && val % 10 == 0;
    }
}
