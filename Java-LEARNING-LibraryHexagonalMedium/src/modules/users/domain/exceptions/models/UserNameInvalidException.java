package modules.users.domain.exceptions.models;

public class UserNameInvalidException extends RuntimeException{
    public UserNameInvalidException(String message){
        super(message);
    }

    public UserNameInvalidException(){
        super();
    }
}
