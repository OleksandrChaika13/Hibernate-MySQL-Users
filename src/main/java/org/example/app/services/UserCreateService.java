package org.example.app.services;

import org.example.app.entity.User;
import org.example.app.exceptions.CreateException;
import org.example.app.repositories.UserCreateRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.EmailValidator;
import org.example.app.utils.UserNameValidator;
import org.example.app.utils.PasswordValidator;

import java.util.HashMap;
import java.util.Map;

public class UserCreateService {

    UserCreateRepository repository;

    public UserCreateService(UserCreateRepository repository) {
        this.repository = repository;
    }

    public String createUser(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new CreateException("Check inputs", errors);
            } catch (CreateException ce) {
                return ce.getErrors(errors);
            }
        }

        return repository.createUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        Map<String, String> errors = new HashMap<>();

        if (data[0].isEmpty() || UserNameValidator.isUserNameValid(data[0])) {
            errors.put("user name", Constants.WRONG_USERNAME_REGEX);
        }

        if (EmailValidator.isEmailValid(data[1]))
            errors.put("email", Constants.WRONG_EMAIL_MSG);

        if (PasswordValidator.isPasswordValid(data[2]))
            errors.put("password", Constants.WRONG_PASSWORD_MSG);

        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setUserName(data[0]);
        user.setEmail(data[1]);
        user.setPassword(data[2]);
        return user;
    }
}