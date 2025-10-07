package models.interfaces;

import java.util.List;
import java.util.Optional;

import models.User;

public interface IUserRepository {
    User save(User user);
    void deleteById(Integer id);
    List<User>findAll();
    Optional<User>findById(Integer id);
}
