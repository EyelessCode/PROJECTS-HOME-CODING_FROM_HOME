package services;

import java.util.List;
import java.util.Optional;

import models.User;
import models.interfaces.IUserRepository;
import models.interfaces.IUserService;

public class UserService implements IUserService{
    private final IUserRepository repository;

    public UserService(IUserRepository repository){
        this.repository=repository;
    }

    @Override
    public void registerUser(User user) {
        if (user!=null) {
            repository.save(user);
        }else{
            throw new NullPointerException("User couldn't be created.");
        }
    }

    @Override
    public Optional<User> findUser(Integer id) {
        if (!repository.findById(id).isEmpty()) {
            return repository.findById(id);
        }
        throw new NullPointerException("User not found.");
    }
    
    /* @Override
    public Optional<User> findUser(String ic) {

        if (!repository.findAll().stream().filter(u->u.getIc().equals(ic)).toList().isEmpty()) {
            return repository.findAll().stream().filter(u->u.getIc().equals(ic)).findFirst();
            // return repository.findAll().stream().filter(u->u.getIc()==ic).findFirst();
        }
        throw new NullPointerException("User not found.");
    } */
    
    @Override
    public List<User> findUser(String value) {
        String search=value.trim().toLowerCase();
        List<User>found=repository.findAll().stream().filter(u->u.getName().toLowerCase().contains(search)||u.getLastname().toLowerCase().contains(search)||u.getIc().equals(search)).toList();
        if (!found.isEmpty()) {
            return found;
        }
        throw new NullPointerException("User not found.");
    }

    @Override
    public List<User> findAllUsers() {
        if (!repository.findAll().isEmpty()) {
            return repository.findAll();
        }
        throw new NullPointerException("There aren't users yet.");
    }
}
