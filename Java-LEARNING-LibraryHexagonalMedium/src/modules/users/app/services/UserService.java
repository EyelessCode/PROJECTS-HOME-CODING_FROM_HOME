package modules.users.app.services;

import java.util.List;
import java.util.Optional;

import modules.users.domain.exceptions.UserCouldNotBeCreated;
import modules.users.domain.exceptions.UsersNotFoundException;
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
    // private final Set<UserIc>icRegistry=new HashSet<>();
    private final IUserRepositoryOutpor repository;

    public UserService(IUserRepositoryOutpor repository){
        this.repository=repository;
    }

    @Override
    public void createUser(String ic, String name, String lastname, String gender, byte age) {
        propertiesExpected(ic, name, lastname);
        icDuplicated(ic);
        User user=new User(
            new UserIc(ic),
            new UserName(name),
            new UserLastname(lastname),
            UserGender.genderValidatorFromInput(gender),
            new UserAge(age)
        );
        if (!(user instanceof User)) {
            throw new UserCouldNotBeCreated("User couldn't be created.");
        }
        repository.save(user);
    }

    @Override
    public List<User> findUsers() {
        boolean isEmpty=repository.getAll().isEmpty();
        if (!isEmpty) {
            return repository.getAll();
        }
        throw new UsersNotFoundException("User list is empty.");
    }

    @Override
    public Optional<User> findUser(Byte id) {
        boolean isEmpty=repository.getAll().isEmpty();
        boolean notFound=repository.getById(id).isEmpty();
        if (isEmpty) {
            throw new UsersNotFoundException("User list is empty.");
        }
        if (!notFound) {
            return repository.getById(id);
        }
        throw new UsersNotFoundException("User couldn't be found.");
    }

    @Override
    public void removeUser(byte id) {
        boolean isEmpty=repository.getAll().isEmpty();
        boolean notFound=repository.getById(id).isEmpty();
        if (isEmpty) {
            throw new UsersNotFoundException("User list is empty.");
        }
        if (!notFound) {
            repository.deleteById(id);
            return;
        }
        throw new UsersNotFoundException("User couldn't be found.");
    }

    @Override
    public List<User> findUsers(String value) {
        boolean isEmpty=repository.getAll().isEmpty();
        if (isEmpty) {
            throw new UsersNotFoundException("User list is empty.");
        }
        String search=value.toLowerCase();
        List<User>users=repository.getAll().stream()
            .filter(param->param.getName().getValue().toLowerCase().contains(search)
                ||param.getLastname().getValue().toLowerCase().contains(search)
                ||param.getIc().getValue().equals(search))
            .toList();
        if (!users.isEmpty()) {
            return users;
        }
        throw new UsersNotFoundException("Users or user couldn't be found.");
    }

    @Override
    public Optional<User> findUser(String ic) {
        boolean isEmpty=repository.getAll().isEmpty();
        if (isEmpty) {
            throw new UsersNotFoundException("User list is empty.");
        }
        Optional<User>found=repository.getAll().stream().filter(user->user.getIc().getValue().equals(ic)).findFirst();
        if (!found.isPresent()) {
            throw new UsersNotFoundException("User couldn't be found.");
        }
        return found;
    }

    @Override
    public void removeUser(String ic) {
        boolean isEmpty=repository.getAll().isEmpty();
        if (isEmpty) {
            throw new UsersNotFoundException("User list is empty.");
        }
        Optional<User>found=repository.getAll().stream().filter(user->user.getIc().getValue().equals(ic)).findFirst();
        if (found.isPresent()) {
            User user=found.get();
            repository.deleteById(user.getId().getValue());
            return;
        }
        throw new UsersNotFoundException("User couldn't be found.");
    }
}
