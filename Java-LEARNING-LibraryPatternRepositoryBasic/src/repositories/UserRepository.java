package repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import models.User;
import models.interfaces.IUserRepository;

public class UserRepository implements IUserRepository{
    public Map<Integer,User>memoryUser=new HashMap<>();
    private Integer currentId=1;

    public UserRepository(){
        int currentByMap=1;
        memoryUser.put(currentByMap++, new User(currentId++, "NAME 1", "LASTNAME 1", "0001", (byte)22, 'M'));
        memoryUser.put(currentByMap++, new User(currentId++, "NAME 2", "LASTNAME 2", "0002", (byte)28, 'F'));
        memoryUser.put(currentByMap++, new User(currentId++, "NAME 3", "LASTNAME 3", "0003", (byte)18, 'M'));
        memoryUser.put(currentByMap++, new User(currentId++, "NAME 4", "LASTNAME 4", "0004", (byte)41, 'F'));
    }

    @Override
    public User save(User user) {
        if (user.getId()==null) {
            user.setId(currentId++);
        }
        memoryUser.put(user.getId(), user);
        return user;
    }

    @Override
    public void deleteById(Integer id) {
        memoryUser.remove(id);
    }

    @Override
    public List<User> findAll() {
        return memoryUser.values().stream().toList();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(memoryUser.get(id));
    }
}
