package org.example.app.utils;

public class UserNameValidator {

    public static boolean isUserNameValid(String userName) {
        return userName.isEmpty() || !userName.matches(Constants.USERNAME_REGEX);
    }
}