package modules.users.domain.exceptions.models;

public class UserAgeInvalidException extends RuntimeException{
    public UserAgeInvalidException(String message){
        super(message);
    }

    public UserAgeInvalidException(){
        super();
    }
}
