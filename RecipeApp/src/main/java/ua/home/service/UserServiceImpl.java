package ua.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ua.home.dao.RecipeDao;
import ua.home.dao.UserDao;
import ua.home.exception.LoginUserException;
import ua.home.exception.RegisterException;
import ua.home.model.Recipe;
import ua.home.model.User;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    RecipeDao recipeDao;
    @Autowired
    Validator validator;

    public UserServiceImpl() {
    }

    public UserServiceImpl(Validator validator, RecipeDao recipeDao, UserDao userDao) {
        this.validator = validator;
        this.recipeDao = recipeDao;
        this.userDao = userDao;
    }

    @Override
    public User registerUser(User user) throws RegisterException {
        if(!validator.validateRegistration(user.getLogin())){
            throw new RegisterException("can not create");
        }
        return userDao.addUser(user);
    }

    @Override
    public User login(String login, String pass) throws LoginUserException {
        if(!validator.validateLogin(login, pass)){
            throw new LoginUserException("incorrect login or pass try again ");
        }
        return findUser(login);
    }

    @Override
    public Recipe makeNewRecipe(Recipe recipe) throws RegisterException {
        if(!validator.validateRecipeRegistration((recipe.getName()))) {
            throw new RegisterException("This recipe exist");
        }
        return recipeDao.addRecipe(recipe);
    }

    @Override
    public List<Recipe> foundRecipe(String ingr) {
        List<Recipe> recipeList = recipeDao.findRecipeByIngredients(ingr);
        if(recipeDao.findRecipeByName(ingr) != null){
            recipeList.add(recipeDao.findRecipeByName(ingr));
        }
        return recipeList;
    }

    @Override
    public List<Recipe> getAllRecipe() {
        return recipeDao.getAllRecipeList();
    }

    @Override
    public boolean addRecipe(Recipe recipe, User user) throws RegisterException {
        boolean res = false;
        recipe = recipeDao.findRecipeByName(recipe.getName());
        if (validator.validateRecipeUser(recipe.getName(), user) &&
                user.getRecipeList().add(recipe) &&
                recipe.getUserList().add(user)){
            //userDao.updateUser(user);
            res = true;
        }
        return res;
    }

    @Override
    public boolean removeRecipe(Recipe recipe, User user) {
        List<Recipe> recipeList = user.getRecipeList();
        boolean res = recipeList.remove(recipe);
        userDao.updateUser(user);
        return res;
    }

    @Override
    public List<Recipe> getAllRecipeUser(User user) {
        return user.getRecipeList();
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User findUser(String login) {
        return userDao.findUser(login);
    }
}
