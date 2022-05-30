package com.example.demo.student.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StateValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StateConstraint {
    String message() default "State not within Nigeria";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
