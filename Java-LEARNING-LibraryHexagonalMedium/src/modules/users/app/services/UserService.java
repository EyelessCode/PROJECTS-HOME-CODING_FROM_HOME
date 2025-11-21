package modules.users.app.services;

import java.util.List;
import java.util.Optional;

import modules.users.domain.exceptions.models.UsersNotFoundException;
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
    private final IUserRepositoryOutpor repository;

    public UserService(IUserRepositoryOutpor repository){
        this.repository=repository;
    }

    @Override
    public void createUser(String ic, String name, String lastname, String gender, Byte age) {
        anythingNull(ic, name, lastname, gender, age);
        icDuplicated(ic); //? only exist in this place (Service) because idk how can i installed in Repository.
        User user=new User(
            new UserIc(ic),
            new UserName(name),
            new UserLastname(lastname),
            UserGender.genderValidatorFromInput(gender),
            new UserAge(age)
        );
        repository.create(user);
    }

    @Override
    public void modifyUser(String ic,String name, String lastname, String gender, Byte age) {
        // anythingNull(name, lastname, gender, age);
        boolean isEmpty=repository.getAll().isEmpty();
        Optional<User> oldUser=repository.getAll().stream().filter(u->u.getIc().getValue().equals(ic)).findFirst();
        if (isEmpty) {
            throw new UsersNotFoundException("User list is empty.");
        }
        if (oldUser.isEmpty()) {
            throw new UsersNotFoundException("User couldn't be found.");
        }
        User user=new User(
            oldUser.get().getIc(),
            new UserName((name.isBlank()||name.isEmpty())?oldUser.get().getName().getValue():name),
            new UserLastname((lastname.isBlank()||lastname.isEmpty())?oldUser.get().getLastname().getValue():lastname),
            UserGender.genderValidatorFromInput((gender.isBlank()||gender.isEmpty())?oldUser.get().getGender().name():gender),
            new UserAge((age==null)?oldUser.get().getAge().getValue():age)
        );
        repository.update(user);
        return;
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
        Optional<User> user=repository.getById(id).stream().findFirst();
        if (isEmpty) {
            throw new UsersNotFoundException("User list is empty.");
        }
        if (!user.isEmpty()) {
            return user;
        }
        throw new UsersNotFoundException("User couldn't be found.");
    }

    @Override
    public void removeUser(byte id) {
        boolean isEmpty=repository.getAll().isEmpty();
        Optional<User> user=repository.getById(id).stream().findFirst();
        if (isEmpty) {
            throw new UsersNotFoundException("User list is empty.");
        }
        if (!user.isEmpty()) {
            repository.deleteById(user.get().getId().getValue());
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
        Optional<User>user=repository.getAll().stream().filter(u->u.getIc().getValue().equals(ic)).findFirst();
        if (isEmpty) {
            throw new UsersNotFoundException("User list is empty.");
        }
        if (!user.isEmpty()) {
            return user;
        }
        throw new UsersNotFoundException("User couldn't be found.");
    }

    @Override
    public void removeUser(String ic) {
        boolean isEmpty=repository.getAll().isEmpty();
        Optional<User>user=repository.getAll().stream().filter(u->u.getIc().getValue().equals(ic)).findFirst();
        if (isEmpty) {
            throw new UsersNotFoundException("User list is empty.");
        }
        if (!user.isEmpty()) {
            // User user=found.get();
            // Byte id=user.getId().getValue();
            repository.deleteById(user.get().getId().getValue());
            icRegistry.remove(user.get().getIc());
            return;
        }
        throw new UsersNotFoundException("User couldn't be found.");
    }
}
