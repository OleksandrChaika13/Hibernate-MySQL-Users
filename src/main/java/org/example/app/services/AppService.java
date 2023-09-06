package org.example.app.services;

import org.example.app.controllers.*;
import org.example.app.exceptions.OptionException;
import org.example.app.repositories.*;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.views.*;

public class AppService {

    public void createUser() {
        UserCreateRepository repository = new UserCreateRepository();
        UserCreateService service = new UserCreateService(repository);
        UserCreateView view = new UserCreateView();
        UserCreateController controller = new UserCreateController(service, view);
        controller.createUser();
    }

    public void readUsers() {
        UserReadRepository repository = new UserReadRepository();
        UserReadService service = new UserReadService(repository);
        UserReadView view = new UserReadView();
        UserReadController controller = new UserReadController(service, view);
        controller.readUser();
    }

    public void updateUser() {
        UserUpdateRepository repository = new UserUpdateRepository();
        UserUpdateService service = new UserUpdateService(repository);
        UserUpdateView view = new UserUpdateView();
        UserUpdateController controller = new UserUpdateController(service, view);
        controller.updateUser();
    }

    public void updateUsername() {
        UserNameUpdateRepository repository = new UserNameUpdateRepository();
        UserNameUpdateService service = new UserNameUpdateService(repository);
        UserNameUpdateView view = new UserNameUpdateView();
        UserNameUpdateController controller = new UserNameUpdateController(service, view);
        controller.updateUserLogin();
    }

    public void updateUserEmail() {
        UserEmailUpdateRepository repository = new UserEmailUpdateRepository();
        UserEmailUpdateService service = new UserEmailUpdateService(repository);
        UserEmailUpdateView view = new UserEmailUpdateView();
        UserEmailUpdateController controller = new UserEmailUpdateController(service, view);
        controller.updateUserEmail();
    }

    public void updateUserPassword() {
        UserPasswordUpdateRepository repository = new UserPasswordUpdateRepository();
        UserPasswordUpdateService service = new UserPasswordUpdateService(repository);
        UserPasswordUpdateView view = new UserPasswordUpdateView();
        UserPasswordUpdateController controller = new UserPasswordUpdateController(service, view);
        controller.updateUserPassword();
    }

    public void deleteUser() {
        UserDeleteRepository repository = new UserDeleteRepository();
        UserDeleteService service = new UserDeleteService(repository);
        UserDeleteView view = new UserDeleteView();
        UserDeleteController controller = new UserDeleteController(service, view);
        controller.deleteUser();
    }

    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2, 3, 4, 5, 6};
        if (!contains(menuChoices, choice)) {
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException e) {
                System.out.println(e.getMessage());
                AppStarter.startApp();
            }
        }
    }

    public static boolean contains(final int[] options, final int value) {
        boolean result = false;
        for (int i : options) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}