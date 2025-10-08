package modules.users.domain.exceptions.models;

public class UserIcInvalidException extends RuntimeException{
    public UserIcInvalidException(String message){
        super(message);
    }

    public UserIcInvalidException(){
        super();
    }
}
