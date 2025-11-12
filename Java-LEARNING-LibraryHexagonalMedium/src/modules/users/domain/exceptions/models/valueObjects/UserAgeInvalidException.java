package modules.users.domain.exceptions.models.valueObjects;

import modules.users.domain.exceptions.models.UserInvalidException;

public class UserAgeInvalidException extends UserInvalidException{
    public UserAgeInvalidException(String message,UserInvalidException ex){
        super(message,ex);
    }

    public UserAgeInvalidException(String message){
        super(message);
    }

    public UserAgeInvalidException(){
        super();
    }
}
