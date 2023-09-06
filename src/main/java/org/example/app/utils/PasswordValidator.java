package org.example.app.utils;

public class PasswordValidator {

    public static boolean isPasswordValid(String id) {
        return id.isEmpty() || !id.matches(Constants.PASSWORD_REGEX);
    }
}