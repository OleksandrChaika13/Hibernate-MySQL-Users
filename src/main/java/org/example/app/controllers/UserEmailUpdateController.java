package org.example.app.controllers;

import org.example.app.services.UserEmailUpdateService;
import org.example.app.utils.AppStarter;
import org.example.app.views.UserEmailUpdateView;

public class UserEmailUpdateController {

    UserEmailUpdateService service;
    UserEmailUpdateView view;

    public UserEmailUpdateController(UserEmailUpdateService service, UserEmailUpdateView view) {
        this.service = service;
        this.view = view;
    }

    public void updateUserEmail() {
        view.getOutput(service.updateUserEmail(view.getData()));
        AppStarter.startApp();
    }
}