package modules.users.domain.exceptions;

public class UserCouldNotBeCreatedException extends RuntimeException{
    public UserCouldNotBeCreatedException(String message){
        super(message);
    }

    public UserCouldNotBeCreatedException(){
        super();
    }
}
