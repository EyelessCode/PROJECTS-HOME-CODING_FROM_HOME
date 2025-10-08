package tests;

import modules.users.domain.models.User;
import modules.users.domain.models.valueObjects.UserAge;
import modules.users.domain.models.valueObjects.UserIc;
import modules.users.domain.models.valueObjects.UserId;
import modules.users.domain.models.valueObjects.UserLastname;
import modules.users.domain.models.valueObjects.UserName;
import modules.users.domain.models.valueObjects.enums.UserGender;

public class TestApp {
    public static void main(String[] args) {
        System.out.println("=".repeat(20));
        User u=new User(new UserIc("0943791061"), new UserName("Cristhian"), new UserLastname("Guedes"), UserGender.M, new UserAge((byte)22));
        System.out.println(u.toString());
        System.out.println("=".repeat(20));
    }

}
