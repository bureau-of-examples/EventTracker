package com.pluralsight.view;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {

    String message() default "{Phone}"; //See message bundle interpolation - https://docs.jboss.org/hibernate/validator/5.1/reference/en-US/html/chapter-message-interpolation.html
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
