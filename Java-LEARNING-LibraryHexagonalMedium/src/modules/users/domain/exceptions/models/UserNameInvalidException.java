package modules.users.domain.exceptions.models;

import modules.users.domain.exceptions.UserCouldNotBeCreatedException;

public class UserNameInvalidException extends UserCouldNotBeCreatedException{
    public UserNameInvalidException(String message){
        super(message);
    }

    public UserNameInvalidException(){
        super();
    }
}
