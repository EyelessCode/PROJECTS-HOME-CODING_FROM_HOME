package modules.users.domain.ports.outport;

import java.util.List;
import java.util.Optional;

import modules.users.domain.models.User;

public interface IUserRepositoryOutpor {
    User create(User user);
    User update(User user);
    List<User>getAll();
    Optional<User> getById(Byte id);
    void deleteById(byte id);
}
