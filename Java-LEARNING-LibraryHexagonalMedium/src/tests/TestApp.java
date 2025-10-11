package tests;

import modules.users.infrastructure.adapters.inbound.controllers.UserController;

public class TestApp {
    public static void main(String[] args) {
        UserController u=new UserController();
        u.userRun();
    }

}
