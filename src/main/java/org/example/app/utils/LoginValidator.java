package org.example.app.utils;

public class LoginValidator {

    public static boolean isLoginValid(String userName) {
        return userName.isEmpty() || !userName.matches(Constants.USERNAME_REGEX);
    }
}