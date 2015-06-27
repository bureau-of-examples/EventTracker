package com.pluralsight.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Constraint(validatedBy = {ValidEventValidator.class})
public @interface ValidEvent {

    String message() default "{com.pluralsight.validation.ValidEvent.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
