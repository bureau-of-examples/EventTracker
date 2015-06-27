package com.pluralsight.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
@Constraint(validatedBy = {EventDurationValidator.class})
public @interface EventDuration {

    String message() default "{com.pluralsight.validation.EventDuration.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
