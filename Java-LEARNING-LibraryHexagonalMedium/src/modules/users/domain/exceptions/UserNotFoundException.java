package modules.users.domain.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }

    public UserNotFoundException(){
        super();
    }
}
