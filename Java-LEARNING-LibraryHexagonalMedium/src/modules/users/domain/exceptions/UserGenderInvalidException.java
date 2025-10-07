package modules.users.domain.exceptions;

public class UserGenderInvalidException extends RuntimeException{
    public UserGenderInvalidException(String message){
        super(message);
    }
}
