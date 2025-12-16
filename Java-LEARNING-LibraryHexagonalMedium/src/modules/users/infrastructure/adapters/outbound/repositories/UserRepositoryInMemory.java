package modules.users.infrastructure.adapters.outbound.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import modules.loans.domain.exceptions.models.valueObjects.UserIdInvalidException;
import modules.users.domain.models.User;
import modules.users.domain.models.valueObjects.UserId;
import modules.users.domain.ports.outport.IUserRepositoryOutpor;

public class UserRepositoryInMemory implements IUserRepositoryOutpor{
    private final Map<UserId,User>userMemory=new HashMap<>();

    @Override
    public User create(User user) {
        return userMemory.putIfAbsent(user.getId(), user);
    }

    @Override
    public User update(User user) {
        Optional<Map.Entry<UserId,User>>exist=userMemory.entrySet().stream().
            filter(u->u.getValue().getIc().getValue().equals(user.getIc().getValue())).findFirst();
        if (exist.isEmpty()){
            throw  new UserIdInvalidException("The user with IC "+user.getIc().getValue()+" does not exist.");
        }
        UserId id=exist.get().getKey();
        return userMemory.put(id, user);
    }

    @Override
    public List<User> getAll() {
        return userMemory.values().stream().toList();
    }

    @Override
    public Optional<User>getById(UserId id) {
        return Optional.ofNullable(userMemory.get(id));
    }

    @Override
    public void deleteById(UserId id) {
        userMemory.remove(id);
    }
}
