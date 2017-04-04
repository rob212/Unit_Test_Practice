package com.robmcbryde;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by robertmcbryde on 14/03/2017.
 */
public class PasswordValidatorTest {

    PasswordValidator validator;


    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidMinPasswordLength_illegalArgumentExcpetionIsThrown() throws Exception {
        validator = new PasswordValidator(-1, 0);
    }

    @Test
    public void givenPasswordLengthIsLessTheanThreshold_whenValidate_thenIsInvalid() throws Exception {
        String password = "123";
        validator = new PasswordValidator(4, 0);
        boolean actual = validator.validate(password);

        assertFalse(actual);
    }

    @Test
    public void givenPasswordLengthEqualsThreshold_whenvalidate_thenIsValid() throws Exception {
        String password = "12345";
        validator = new PasswordValidator(5, 0);
        boolean actual = validator.validate(password);

        assertTrue(actual);
    }

    @Test
    public void givenPasswordLengthGreaterThanThreshold_whenvalidate_thenIsValid() throws Exception {
        String password = "12345678910";
        validator = new PasswordValidator(10, 0);
        boolean actual = validator.validate(password);

        assertTrue(actual);
    }

    @Test
    public void givenPasswordValidatorHasMinDigitsSet_whenPasswordHasLessDigits_thenIsInvalid() throws Exception {
        String password = "abcde";
        validator = new PasswordValidator(3, 2);

        boolean actual = validator.validate(password);

        assertFalse(actual);
    }
}