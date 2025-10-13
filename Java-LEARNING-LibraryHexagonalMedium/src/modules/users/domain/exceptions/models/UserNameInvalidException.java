package modules.users.domain.exceptions.models;

import modules.users.domain.exceptions.UserInvalidException;

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
