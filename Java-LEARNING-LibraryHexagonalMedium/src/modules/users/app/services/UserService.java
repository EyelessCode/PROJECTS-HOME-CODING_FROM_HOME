package modules.users.app.services;

import java.util.List;

import modules.users.domain.exceptions.UserNotFoundException;
import modules.users.domain.models.User;
import modules.users.domain.models.valueObjects.UserAge;
import modules.users.domain.models.valueObjects.UserIc;
import modules.users.domain.models.valueObjects.UserLastname;
import modules.users.domain.models.valueObjects.UserName;
import modules.users.domain.models.valueObjects.enums.UserGender;
import modules.users.domain.ports.inport.IUserServiceInport;
import modules.users.domain.ports.outport.IUserRepositoryOutpor;
import modules.users.domain.services.UserServiceValidator;

public class UserService extends UserServiceValidator implements IUserServiceInport{
    private IUserRepositoryOutpor repository;

    public UserService(IUserRepositoryOutpor repository){
        this.repository=repository;
    }

    @Override
    public void createUser(String ic, String name, String lastname, String gender, byte age) {
        propertiesExpected(ic, name, lastname);
        User user=new User(
            new UserIc(ic),
            new UserName(name),
            new UserLastname(lastname),
            UserGender.genderValidatorFromInput(gender),
            new UserAge(age)
        );
        repository.save(user);
    }

    @Override
    public List<User> findUsers() {
        boolean isEmpty=repository.getAll().isEmpty();
        if (!isEmpty) {
            return repository.getAll();
        }
        throw new UserNotFoundException("Users couldn't be found.");
    }

    @Override
    public byte findUserById(byte id) {
        boolean isEmpty=repository.getById(id).isEmpty();
        if (!isEmpty) {
            return repository.getById(id).get().getId().getValue();
        }
        throw new UserNotFoundException("User couldn't be found.");
    }

    @Override
    public void removeUserById(byte id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeUserById'");
    }

    @Override
    public List<User> findUsersByFullnameOrIc(String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUsersByFullnameOrIc'");
    }
    
}
