package org.example.app.services;

import org.example.app.entity.User;
import org.example.app.exceptions.UpdateException;
import org.example.app.repositories.UserPasswordUpdateRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.IdValidator;
import org.example.app.utils.PasswordValidator;

import java.util.HashMap;
import java.util.Map;

public class UserPasswordUpdateService {

    UserPasswordUpdateRepository repository;

    public UserPasswordUpdateService(UserPasswordUpdateRepository repository) {
        this.repository = repository;
    }

    public String updateUser(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Check inputs", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }

        return repository.updateUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        Map<String, String> errors = new HashMap<>();

        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Constants.WRONG_ID_MSG);

        if (PasswordValidator.isPasswordValid(data[1]))
            errors.put("password", Constants.WRONG_PASSWORD_MSG);

        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setId(Integer.parseInt(data[0]));
        user.setPassword(data[1]);
        return user;
    }
}