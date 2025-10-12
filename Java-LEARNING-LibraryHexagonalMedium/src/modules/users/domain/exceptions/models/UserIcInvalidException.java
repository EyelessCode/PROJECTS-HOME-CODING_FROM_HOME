package modules.users.domain.exceptions.models;

import modules.users.domain.exceptions.UserCouldNotBeCreatedException;

public class UserIcInvalidException extends UserCouldNotBeCreatedException{
    public UserIcInvalidException(String message){
        super(message);
    }

    public UserIcInvalidException(){
        super();
    }
}
