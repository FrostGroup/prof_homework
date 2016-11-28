package ua.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ua.home.dao.RecipeDao;
import ua.home.dao.UserDao;
import ua.home.exception.RegisterException;
import ua.home.model.Recipe;
import ua.home.model.User;

import java.util.List;

@Service
public class ValidatorImpl implements Validator {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RecipeDao recipeDao;

    public ValidatorImpl() {
    }

    public ValidatorImpl(UserDao userDao, RecipeDao recipeDao) {
        this.userDao = userDao;
        this.recipeDao = recipeDao;
    }

    @Override
    public boolean validateLogin(String login, String pass) {

        boolean result =false;

        if(login == null || pass == null){
            return result;
        }

        if(userDao.findUser(login) != null &&
                userDao.findUser(login).getPass().equals(pass)){
            result = true;
        }
        return result;
    }

    @Override
    public boolean validateRegistration (String login) throws RegisterException {
        boolean result = true;
        if(login == null || userDao.findUser(login) != null){
            throw new RegisterException("Login using already");
        }
        return result;
    }

    @Override
    public boolean validateRecipeRegistration(String name) throws RegisterException {
        boolean result = true;
        if(name == null || recipeDao.findRecipeByName(name) != null){
            throw new RegisterException("This recipe exist");
        }
        return result;
    }

    @Override
    public boolean validateRecipeUser(String recipeName, User user) throws RegisterException{
        boolean result = true;
        if(recipeName == null || !findRecipeInUser(user, recipeName)){
            result = false;
            return result;
        }

        return result;
    }

    private boolean findRecipeInUser(User user, String recipeName) {
        boolean result = true;
        List<Recipe> recipeList = user.getRecipeList();
        for (Recipe recipe : recipeList) {
            if (recipe.getName().equals(recipeName)) {
                result = false;
                return result;
            }
        }
        return result;
    }
}
