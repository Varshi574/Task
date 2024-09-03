package com.tms.user.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidPidValidator.class)
public @interface ValidPid {

    String message() default "Invalid PID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
