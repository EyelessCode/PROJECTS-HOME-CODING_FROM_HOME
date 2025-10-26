package modules.users.app.services;

import java.util.List;
import java.util.Optional;

import modules.users.domain.exceptions.UsersNotFoundException;
import modules.users.domain.models.User;
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
        repository.save(ic,name,lastname,gender,age);
    }

    @Override
    public void modifyUser(String ic,String name, String lastname, String gender, Byte age) {
        anythingNull(name, lastname, gender, age);
        // User user=findUser(ic).get();
        Optional<User> user=repository.getAll().stream().filter(u->u.getIc().getValue().equals(ic)).findFirst();
        if (!user.isEmpty()) {
            // boolean isPresent=icRegistry.contains(user.getIc());
            repository.update(ic,name,lastname,gender,age);
            return;
            // throw new UsersNotFoundException("User couldn't be found.");
        }
        throw new UsersNotFoundException("User couldn't be found.");
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
            return repository.getById(id);
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
        if (!found.isEmpty()) {
            User user=found.get();
            Byte id=user.getId().getValue();
            repository.deleteById(id);
            icRegistry.remove(found.get().getIc());
            return;
        }
        throw new UsersNotFoundException("User couldn't be found.");
    }
}
