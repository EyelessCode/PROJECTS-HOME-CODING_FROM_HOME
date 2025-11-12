package modules.users.domain.exceptions.models.valueObjects;

import modules.users.domain.exceptions.models.UserInvalidException;

public class UserGenderInvalidException extends UserInvalidException{
    public UserGenderInvalidException(String message,UserInvalidException ex){
        super(message,ex);
    }

    public UserGenderInvalidException(String message){
        super(message);
    }

    public UserGenderInvalidException(){
        super();
    }
}
