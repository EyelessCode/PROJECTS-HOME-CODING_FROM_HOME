package modules.users.domain.exceptions.models;

public class UserInvalidException extends RuntimeException{
    public UserInvalidException(String message,RuntimeException ex){
        super(message, ex);
    }

    public UserInvalidException(String message){
        super(message);
    }

    public UserInvalidException(){
        super();
    }
}
