package modules.users.domain.services;

import java.util.HashSet;
import java.util.Set;

import modules.users.domain.exceptions.models.UserIcInvalidException;
import modules.users.domain.exceptions.models.UserNameInvalidException;
import modules.users.domain.models.valueObjects.UserIc;

public abstract class UserServiceValidator {
    private final Set<UserIc>icRegistry=new HashSet<>();
    protected void propertiesExpected(String ic,String name,String lastname){
        if (ic==null) {
            throw new UserNameInvalidException("User's IC cannot be null value.");
        }
        UserIc userIc=new UserIc(ic);
        if (icRegistry.contains(userIc)) {
            throw new UserIcInvalidException("This User's IC has been used.");
        }
        if (name==null||lastname==null) {
            throw new UserNameInvalidException("User's name or lastname cannot be null value");
        }
        icRegistry.add(userIc);
    }
}
