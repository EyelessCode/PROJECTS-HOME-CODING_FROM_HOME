package modules.users.domain.exceptions.models;

import modules.users.domain.exceptions.UserCouldNotBeCreatedException;

public class UserGenderInvalidException extends UserCouldNotBeCreatedException{
    public UserGenderInvalidException(String message){
        super(message);
    }

    public UserGenderInvalidException(){
        super();
    }
}
