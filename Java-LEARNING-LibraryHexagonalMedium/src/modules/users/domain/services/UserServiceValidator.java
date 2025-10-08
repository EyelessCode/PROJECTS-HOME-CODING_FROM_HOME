package modules.users.domain.services;

import modules.users.domain.exceptions.models.UserNameInvalidException;

public abstract class UserServiceValidator {
    protected void propertiesExpected(String ic,String name,String lastname){
        if (ic==null) {
            throw new UserNameInvalidException("User's IC cannot be null value.");
        }
        if (name==null||lastname==null) {
            throw new UserNameInvalidException("User's name or lastname cannot be null value");
        }
    }
}
