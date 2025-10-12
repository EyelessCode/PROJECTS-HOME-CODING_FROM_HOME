package modules.users.domain.exceptions;

public class UsersNotFoundException extends UserCouldNotBeCreatedException{
    public UsersNotFoundException(String message){
        super(message);
    }

    public UsersNotFoundException(){
        super();
    }
}
