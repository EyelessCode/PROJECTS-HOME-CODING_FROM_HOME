package modules.users.domain.exceptions;

public class UsersNotFoundException extends RuntimeException{
    public UsersNotFoundException(String message){
        super(message);
    }

    public UsersNotFoundException(){
        super();
    }
}
