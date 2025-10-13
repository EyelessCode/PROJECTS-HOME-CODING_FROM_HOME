package modules.users.domain.exceptions.models;

import modules.users.domain.exceptions.UserInvalidException;

public class UserIcInvalidException extends UserInvalidException{
    public UserIcInvalidException(String message,UserInvalidException ex){
        super(message,ex);
    }

    public UserIcInvalidException(String message){
        super(message);
    }

    public UserIcInvalidException(){
        super();
    }
}
