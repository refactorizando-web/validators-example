package com.refactorizando.example.validator.config;

import com.refactorizando.example.validator.dto.CarDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LengthValidatorTest {

    @Test
    void whenValidatorIsInvoked_givenAStringGreaterThan10_thenReturnFalse() throws Exception {

        LengthValidator lengthValidator = new LengthValidator();
        Boolean isValid = lengthValidator.isValid("dfaiuruqrqurewqrewqfdsa", null);

        assert !isValid;

    }

    @Test
    void whenValidatorIsInvoked_givenAStringLessThan10_thenReturnTrue() throws Exception {

        LengthValidator lengthValidator = new LengthValidator();
        Boolean isValid = lengthValidator.isValid("df", null);

        assert isValid;

    }
}
