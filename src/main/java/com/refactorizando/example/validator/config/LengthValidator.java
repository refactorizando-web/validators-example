package com.refactorizando.example.validator.config;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LengthValidator implements ConstraintValidator<LengthValidation, String> {

    public boolean isValid(String field, ConstraintValidatorContext cxt) {
        return field.length() < 10;
    }
}
