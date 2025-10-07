package models.interfaces;

import java.util.List;
import java.util.Optional;

import models.User;

public interface IUserService {
    void registerUser(User user);
    Optional<User>findUser(Integer id);
    // Optional<User>findUser(String ic);
    List<User>findUser(String value);
    List<User>findAllUsers();
}
