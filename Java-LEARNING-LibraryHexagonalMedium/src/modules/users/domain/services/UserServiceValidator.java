package modules.users.domain.services;

import java.util.HashSet;
import java.util.Set;

import modules.users.domain.exceptions.models.UserCouldNotBeCreatedException;
import modules.users.domain.exceptions.models.valueObjects.UserIcInvalidException;
import modules.users.domain.models.valueObjects.UserIc;

public abstract class UserServiceValidator {
    protected final Set<UserIc>icRegistry=new HashSet<>();

    protected void icDuplicated(String ic){
        UserIc userIc=new UserIc(ic);
        if (icRegistry.contains(userIc)) {
            throw new UserIcInvalidException("User's IC already registered.");
        }
        icRegistry.add(userIc);
    }

    protected void anythingNull(String ic, String name, String lastname, String gender, Byte age){
        if (((ic == null && name == null) || (lastname == null && gender == null)) || (age == null)) {
            throw new UserCouldNotBeCreatedException("User couldn't be created. Null values found.");
        }
    }

    protected void anythingNull(String name, String lastname, String gender, Byte age){
        if ((name == null && lastname == null) || (gender == null && age == null)) {
            throw new UserCouldNotBeCreatedException("User couldn't be created. Null values found.");
        }
    }
}
