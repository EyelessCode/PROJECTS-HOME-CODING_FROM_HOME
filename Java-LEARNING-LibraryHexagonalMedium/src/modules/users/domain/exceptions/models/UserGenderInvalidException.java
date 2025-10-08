package modules.users.domain.exceptions.models;

public class UserGenderInvalidException extends RuntimeException{
    public UserGenderInvalidException(String message){
        super(message);
    }

    public UserGenderInvalidException(){
        super();
    }
}
