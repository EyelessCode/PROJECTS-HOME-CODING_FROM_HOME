package modules.users.domain.ports.inport;

import java.util.List;
import java.util.Optional;

import modules.users.domain.models.User;

public interface IUserServiceInport {
    //? I'll make the instance over all classes.
    //todo: CRUD
    void createUser(String ic,String name,String lastname,String gender,Byte age);
    List<User>findUsers();
    Optional<User>findUser(Byte id);
    void removeUser(byte id);
    
    //todo: methods to improve UX.
    List<User>findUsers(String value);
    Optional<User>findUser(String ic);
    void removeUser(String ic);
}
