package com.pluralsight.test;

import com.pluralsight.model.Attendee;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class AttendeeValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Attendee.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Attendee attendee = (Attendee) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        if(errors.getErrorCount() == 0)
            if ("Michael".equals(attendee.getName())) {
                errors.reject("MichaelIsNotAllowed");
            }
    }
}
