package modules.users.domain.exceptions.models;

public class UserCouldNotBeCreatedException extends UserInvalidException{
    public UserCouldNotBeCreatedException(String message,UserInvalidException ex){
        super(message,ex);
    }

    public UserCouldNotBeCreatedException(String message){
        super(message);
    }

    public UserCouldNotBeCreatedException(){
        super();
    }
}
