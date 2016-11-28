package ua.home.dao;

import ua.home.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 23.08.2016.
 */
public interface UserDao {

    User addUser (User user);

    User removeUser (User user);

    List<User> getAllUsers ();

    User updateUser(User user);

    User findUser (String login);

    User findUserById (int id);
}
