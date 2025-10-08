package modules.users.domain.ports.outport;

import java.util.List;
import java.util.Optional;

import modules.users.domain.models.User;

public interface IUserRepositoryOutpor {
    User save(User user);
    List<User>getAll();
    Optional<User> getById(byte id);
    void deleteById(byte id);
}
