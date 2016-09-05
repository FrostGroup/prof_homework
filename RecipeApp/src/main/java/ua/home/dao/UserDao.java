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

    List<User> usersList ();

    User findUser (Map<String, String> map);

    User findUserById (int id);
}
