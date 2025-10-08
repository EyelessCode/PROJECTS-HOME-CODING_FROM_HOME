package modules.users.domain.exceptions;

public class UserAgeInvalidException extends RuntimeException{
    public UserAgeInvalidException(String message){
        super(message);
    }
}
