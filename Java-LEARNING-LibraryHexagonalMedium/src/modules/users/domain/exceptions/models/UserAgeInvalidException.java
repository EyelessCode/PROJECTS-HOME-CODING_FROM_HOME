package modules.users.domain.exceptions.models;

import modules.users.domain.exceptions.UserCouldNotBeCreatedException;

public class UserAgeInvalidException extends UserCouldNotBeCreatedException{
    public UserAgeInvalidException(String message){
        super(message);
    }

    public UserAgeInvalidException(){
        super();
    }
}
