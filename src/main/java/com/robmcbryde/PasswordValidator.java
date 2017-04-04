package com.robmcbryde;

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
        int digitCount = (int) password.chars()
            .mapToObj(i -> (char)i)
            .filter(Character::isDigit)
            .count();

        return digitCount >= minDigits;
    }
}
