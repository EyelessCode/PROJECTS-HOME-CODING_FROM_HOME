package modules.users.domain.ports.outport;

import java.util.List;
import java.util.Optional;

import modules.users.domain.models.User;

public interface IUserRepositoryOutpor {
    User save(String ic, String name, String lastname, String gender, Byte age);
    List<User>getAll();
    Optional<User> getById(Byte id);
    void deleteById(byte id);
}
