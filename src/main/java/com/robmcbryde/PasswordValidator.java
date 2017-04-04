package com.robmcbryde;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by robertmcbryde on 14/03/2017.
 */
public class PasswordValidator {

    private final int minDigits;
    private final int minLength;

    public PasswordValidator(int minLength, int minDigits) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Password Validator min password length cannot be a negative number");
        }
        this.minLength = minLength;
        this.minDigits = minDigits;
    }

    public boolean validate(String password) {
        return password.length() >= minLength && hasValidDigitCount(password);
    }

    private boolean hasValidDigitCount(String password) {
        int digitCount = 0;
         char[] digits = password.toCharArray();
        for (char c: digits ) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }
        return digitCount >= minDigits ? true : false;
    }
}
