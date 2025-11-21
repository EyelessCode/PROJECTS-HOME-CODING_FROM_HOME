package modules.users.domain.ports.outport;

import java.util.List;
import java.util.Optional;

import modules.users.domain.models.User;
import modules.users.domain.models.valueObjects.UserId;

public interface IUserRepositoryOutpor {
    User create(User user);
    User update(User user);
    List<User>getAll();
    Optional<User>getById(UserId id);
    void deleteById(UserId id);
}
