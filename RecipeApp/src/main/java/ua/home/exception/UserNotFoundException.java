package ua.home.exception;

/**
 * Created by Alex on 15.09.2016.
 */
public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
