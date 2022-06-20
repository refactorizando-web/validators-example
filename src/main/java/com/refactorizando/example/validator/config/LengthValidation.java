package com.refactorizando.example.validator.config;

import javax.validation.Payload;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target( { FIELD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = LengthValidator.class)
public @interface LengthValidation {
    public String message() default "Invalid length: the length must be less than 10";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
