package modules.users.app.services;

import java.util.List;
import java.util.Optional;

import modules.users.domain.exceptions.models.UsersNotFoundException;
import modules.users.domain.models.User;
import modules.users.domain.models.valueObjects.UserAge;
import modules.users.domain.models.valueObjects.UserIc;
import modules.users.domain.models.valueObjects.UserId;
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
        icDuplicated(ic); //? only exist in this place (Service) because idk how can I installed in Repository.
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
        boolean isEmpty=repository.getAll().isEmpty();
        Optional<User> oldUser=repository.getAll().stream().filter(u->u.getIc().getValue().equals(ic)).findFirst();
        if (isEmpty) {
            throw new UsersNotFoundException("User list is empty.");
        }
        if (oldUser.isEmpty()) {
            throw new UsersNotFoundException("User with '"+ic+"' IC couldn't be found.");
        }
        User user=new User(
            oldUser.get().getId(),
            oldUser.get().getIc(),
            new UserName(name.isBlank() ?oldUser.get().getName().getValue():name),
            new UserLastname(lastname.isBlank() ?oldUser.get().getLastname().getValue():lastname),
            UserGender.genderValidatorFromInput(gender.isBlank() ?oldUser.get().getGender().name():gender),
            new UserAge((age==null)?oldUser.get().getAge().getValue():age)
        );
        repository.update(user);
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
        Optional<User> user=repository.getById(new UserId(id)).stream().findFirst();
        if (isEmpty) {
            throw new UsersNotFoundException("User list is empty.");
        }
        if (user.isPresent()) {
            return user;
        }
        throw new UsersNotFoundException("User with '"+id+"' ID couldn't be found.");
    }

    @Override
    public void removeUser(byte id) {
        boolean isEmpty=repository.getAll().isEmpty();
        Optional<User> user=repository.getById(new UserId(id)).stream().findFirst();
        if (isEmpty) {
            throw new UsersNotFoundException("User list is empty.");
        }
        if (user.isPresent()) {
            repository.deleteById(user.get().getId());
            return;
        }
        throw new UsersNotFoundException("User with '"+id+"' ID couldn't be found.");
    }

    @Override
    public List<User> findUsers(String value) {
        String search=value.toLowerCase();
        boolean isEmpty=repository.getAll().isEmpty();
        if (isEmpty) {
            throw new UsersNotFoundException("User list is empty.");
        }
        List<User>users=repository.getAll().stream()
            .filter(param->param.getName().getValue().toLowerCase().contains(search)
                ||param.getLastname().getValue().toLowerCase().contains(search)
                ||param.getIc().getValue().equals(search))
            .toList();
        if (!users.isEmpty()) {
            return users;
        }
        throw new UsersNotFoundException("User with '"+value+"' couldn't be found.");
    }

    @Override
    public Optional<User> findUser(String ic) {
        boolean isEmpty=repository.getAll().isEmpty();
        Optional<User>user=repository.getAll().stream().filter(u->u.getIc().getValue().equals(ic)).findFirst();
        if (isEmpty) {
            throw new UsersNotFoundException("User list is empty.");
        }
        if (user.isPresent()) {
            return user;
        }
        throw new UsersNotFoundException("User with '"+ic+"' IC couldn't be found.");
    }

    @Override
    public void removeUser(String ic) {
        boolean isEmpty=repository.getAll().isEmpty();
        Optional<User>user=repository.getAll().stream().filter(u->u.getIc().getValue().equals(ic)).findFirst();
        if (isEmpty) {
            throw new UsersNotFoundException("User list is empty.");
        }
        if (user.isPresent()) {
            repository.deleteById(user.get().getId());
            icRegistry.remove(user.get().getIc());
            return;
        }
        throw new UsersNotFoundException("User with '"+ic+"' IC couldn't be found.");
    }
}
