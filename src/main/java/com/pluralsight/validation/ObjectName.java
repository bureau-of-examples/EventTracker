package com.pluralsight.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

@ReportAsSingleViolation
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {})
@Target({ElementType.FIELD, ElementType.METHOD})
@NotNull()
@Size(min = 2, max = 20)
public @interface ObjectName {

    String message() default "{com.pluralsight.validation.ObjectName.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
