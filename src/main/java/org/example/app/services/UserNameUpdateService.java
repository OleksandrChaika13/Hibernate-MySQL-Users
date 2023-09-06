package org.example.app.services;

import org.example.app.entity.User;
import org.example.app.exceptions.UpdateException;
import org.example.app.repositories.UserNameUpdateRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.IdValidator;
import org.example.app.utils.UserNameValidator;

import java.util.HashMap;
import java.util.Map;

public class UserNameUpdateService {

    UserNameUpdateRepository repository;

    public UserNameUpdateService(UserNameUpdateRepository repository) {
        this.repository = repository;
    }

    public String updateUserName(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Check inputs", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }

        return repository.updateUserName(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        Map<String, String> errors = new HashMap<>();

        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Constants.WRONG_ID_MSG);

        if (UserNameValidator.isUserNameValid(data[1]))
            errors.put("user name", Constants.WRONG_USERNAME_REGEX);

        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setId(Integer.parseInt(data[0]));
        user.setUserName(data[1]);
        return user;
    }
}