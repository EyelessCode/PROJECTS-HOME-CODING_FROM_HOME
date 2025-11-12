package modules.users.domain.exceptions.models.valueObjects;

import modules.users.domain.exceptions.models.UserInvalidException;

public class UserIdInvalidException extends UserInvalidException{
    public UserIdInvalidException(String message,UserInvalidException ex){
        super(message,ex);
    }

    public UserIdInvalidException(String message){
        super(message);
    }

    public UserIdInvalidException(){
        super();
    }
}
