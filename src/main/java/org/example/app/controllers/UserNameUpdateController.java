package org.example.app.controllers;

import org.example.app.services.UserNameUpdateService;
import org.example.app.utils.AppStarter;
import org.example.app.views.UserNameUpdateView;

public class UserNameUpdateController {

    UserNameUpdateService service;
    UserNameUpdateView view;

    public UserNameUpdateController(UserNameUpdateService service, UserNameUpdateView view) {
        this.service = service;
        this.view = view;
    }

    public void updateUserLogin() {
        view.getOutput(service.updateUserName(view.getData()));
        AppStarter.startApp();
    }
}