package modules.users.infrastructure.adapters.outbound.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import modules.users.domain.models.User;
import modules.users.domain.models.valueObjects.UserAge;
import modules.users.domain.models.valueObjects.UserIc;
import modules.users.domain.models.valueObjects.UserId;
import modules.users.domain.models.valueObjects.UserLastname;
import modules.users.domain.models.valueObjects.UserName;
import modules.users.domain.models.valueObjects.enums.UserGender;
import modules.users.domain.ports.outport.IUserRepositoryOutpor;

public class UserRepositoryInMemory implements IUserRepositoryOutpor{
    private byte currentId=1;
    private Map<UserId,User>userMemory=new HashMap<>();

    //? Initial local datas (For testing).
    public UserRepositoryInMemory(){
        userMemory.put(new UserId(currentId++), new User(new UserIc("0974852960"), new UserName("Roberto"), new UserLastname("Mendoza"), UserGender.M, new UserAge((byte)29)));
        userMemory.put(new UserId(currentId++), new User(new UserIc("0985987874"), new UserName("Daniel"), new UserLastname("Mendoza"), UserGender.M, new UserAge((byte)23)));
        userMemory.put(new UserId(currentId++), new User(new UserIc("0969963695"), new UserName("Lenin"), new UserLastname("Castillo"), UserGender.M, new UserAge((byte)41)));
        userMemory.put(new UserId(currentId++), new User(new UserIc("0958852100"), new UserName("Esther"), new UserLastname("Verdezoto"), UserGender.F, new UserAge((byte)14)));
        userMemory.put(new UserId(currentId++), new User(new UserIc("0990010147"), new UserName("Nicole"), new UserLastname("Demara"), UserGender.F, new UserAge((byte)21)));
    }

    @Override
    public User create(User user) {
        User newUser=userMemory.putIfAbsent(new UserId(null), user);
        return newUser;
    }

    @Override
    public User update(User user) {
        Optional<Map.Entry<UserId,User>>exist=userMemory.entrySet().stream().
            filter(u->u.getValue().getIc().getValue().equals(user.getIc().getValue())).findFirst();
        UserId id=exist.get().getKey();
        // UserIc ic=exist.get().getValue().getIc();
        User updatedUser=userMemory.put(id, user);
        return updatedUser;
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
