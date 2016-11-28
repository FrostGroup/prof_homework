package ua.home.service;

import ua.home.exception.LoginUserException;
import ua.home.exception.RegisterException;
import ua.home.model.Recipe;
import ua.home.model.User;

import java.util.List;

/**
 * Created by Alex on 19.09.2016.
 */
public interface UserService {

    User registerUser(User user) throws RegisterException;

    User login(String login, String pass) throws LoginUserException;

    Recipe makeNewRecipe(Recipe recipe) throws RegisterException;

    List<Recipe> foundRecipe(String ingr);

    List<Recipe> getAllRecipe();

    List<Recipe> getAllRecipeUser(User user);

    boolean removeRecipe(Recipe recipe, User user);

    boolean addRecipe(Recipe recipe, User user) throws RegisterException;

    User updateUser(User user);

    List<User> getAllUsers();

    User findUser(String login);



}
