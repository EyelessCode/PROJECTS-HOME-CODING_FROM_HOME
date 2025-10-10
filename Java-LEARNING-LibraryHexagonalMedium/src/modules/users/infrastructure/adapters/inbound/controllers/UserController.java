package modules.users.infrastructure.adapters.inbound.controllers;

import modules.users.app.services.UserService;
import modules.users.domain.ui.console.views.UserConsoleView;
import modules.users.infrastructure.adapters.outbound.repositories.UserRepositoryInMemory;

public class UserController extends UserConsoleView{
    private UserService service;

    public UserController(){
        UserRepositoryInMemory repository=new UserRepositoryInMemory();
        this.service=new UserService(repository);
    }

    public void userRun(){
        options();
    }
}
