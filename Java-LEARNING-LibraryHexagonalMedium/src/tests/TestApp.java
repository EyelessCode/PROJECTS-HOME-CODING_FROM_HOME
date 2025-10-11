package tests;

import modules.users.domain.models.User;
import modules.users.domain.models.valueObjects.UserAge;
import modules.users.domain.models.valueObjects.UserIc;
import modules.users.domain.models.valueObjects.UserId;
import modules.users.domain.models.valueObjects.UserLastname;
import modules.users.domain.models.valueObjects.UserName;
import modules.users.domain.models.valueObjects.enums.UserGender;
import modules.users.infrastructure.adapters.inbound.controllers.UserController;

public class TestApp {
    public static void main(String[] args) {
        UserController u=new UserController();
        u.userRun();
    }

}
