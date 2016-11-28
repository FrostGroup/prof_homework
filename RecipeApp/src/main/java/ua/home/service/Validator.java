package ua.home.service;

import ua.home.exception.RegisterException;
import ua.home.model.User;

/**
 * Created by Alex on 19.09.2016.
 */
public interface Validator {

    boolean validateLogin(String login, String pass);
    boolean validateRegistration (String login) throws RegisterException;
    boolean validateRecipeRegistration(String name) throws RegisterException;
    boolean validateRecipeUser(String recipeName, User user) throws RegisterException;
}
