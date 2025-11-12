package modules.users.domain.exceptions.models;

public class UsersNotFoundException extends UserCouldNotBeCreatedException{
    public UsersNotFoundException(String message,UserInvalidException ex){
        super(message,ex);
    }

    public UsersNotFoundException(String message){
        super(message);
    }

    public UsersNotFoundException(){
        super();
    }
}
