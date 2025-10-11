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

    public UserRepositoryInMemory(){
        userMemory.put(new UserId(currentId++), new User(new UserIc("0974852960"), new UserName("Roberto"), new UserLastname("Mendoza"), UserGender.M, new UserAge((byte)29)));
        userMemory.put(new UserId(currentId++), new User(new UserIc("0985987874"), new UserName("Daniel"), new UserLastname("Mendoza"), UserGender.M, new UserAge((byte)23)));
        userMemory.put(new UserId(currentId++), new User(new UserIc("0969963695"), new UserName("Lenin"), new UserLastname("Castillo"), UserGender.M, new UserAge((byte)41)));
        userMemory.put(new UserId(currentId++), new User(new UserIc("0958852100"), new UserName("Esther"), new UserLastname("Verdezoto"), UserGender.F, new UserAge((byte)14)));
        userMemory.put(new UserId(currentId++), new User(new UserIc("0990010147"), new UserName("Nicole"), new UserLastname("Demara"), UserGender.F, new UserAge((byte)21)));
    }

    @Override
    public User save(User user) {
        return userMemory.put(user.getId(), user);
    }

    @Override
    public List<User> getAll() {
        return userMemory.values().stream().toList();
    }

    @Override
    public Optional<User> getById(Byte id) {
        return Optional.ofNullable(userMemory.get(new UserId(id)));
    }

    @Override
    public void deleteById(byte id) {
        userMemory.get(new UserId(id));
    }
}
