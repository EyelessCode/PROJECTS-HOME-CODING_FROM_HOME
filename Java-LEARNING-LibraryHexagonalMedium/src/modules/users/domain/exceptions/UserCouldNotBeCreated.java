package modules.users.domain.exceptions;

public class UserCouldNotBeCreated extends RuntimeException{
    public UserCouldNotBeCreated(String message){
        super(message);
    }

    public UserCouldNotBeCreated(){
    }
}
