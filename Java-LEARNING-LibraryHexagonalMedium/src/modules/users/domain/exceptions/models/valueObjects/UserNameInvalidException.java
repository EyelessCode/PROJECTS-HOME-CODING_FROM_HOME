package modules.users.domain.exceptions.models.valueObjects;

import modules.users.domain.exceptions.models.UserInvalidException;

public class UserNameInvalidException extends UserInvalidException{
    public UserNameInvalidException(String message,UserInvalidException ex){
        super(message,ex);
    }

    public UserNameInvalidException(String message){
        super(message);
    }

    public UserNameInvalidException(){
        super();
    }
}
