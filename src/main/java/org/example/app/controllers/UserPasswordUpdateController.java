package org.example.app.controllers;

import org.example.app.services.UserPasswordUpdateService;
import org.example.app.utils.AppStarter;
import org.example.app.views.UserPasswordUpdateView;

public class UserPasswordUpdateController {

    UserPasswordUpdateService service;
    UserPasswordUpdateView view;

    public UserPasswordUpdateController(UserPasswordUpdateService service, UserPasswordUpdateView view) {
        this.service = service;
        this.view = view;
    }

    public void updateUserPassword() {
        view.getOutput(service.updateUser(view.getData()));
        AppStarter.startApp();
    }
}