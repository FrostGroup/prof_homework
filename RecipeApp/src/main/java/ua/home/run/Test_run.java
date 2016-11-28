package ua.home.run;

import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import ua.home.dao.RecipeDao;
import ua.home.dao.RecipeDaoImpl;
import ua.home.dao.UserDao;
import ua.home.dao.UserDaoImpl;
import ua.home.exception.LoginUserException;
import ua.home.exception.RegisterException;
import ua.home.model.Recipe;
import ua.home.model.User;
import ua.home.service.UserService;
import ua.home.service.UserServiceImpl;
import ua.home.service.Validator;
import ua.home.service.ValidatorImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 30.09.2016.
 */
public class Test_run {
    public static void main(String[] args) throws RegisterException, LoginUserException {

        RecipeDao recipeDao = new RecipeDaoImpl();
        UserDao userDao = new UserDaoImpl();
        Validator validator = new ValidatorImpl(userDao, recipeDao);
        UserService userService = new UserServiceImpl(validator, recipeDao, userDao);


        Recipe recipe1 = new Recipe("somesing", "first second last", "tuch all");
        Recipe recipe3 = new Recipe("tuch all", "first second last", "8888888");
        Recipe recipe2 = new Recipe("somesing555", "first second last2", "tuch all2");
        User user1 = new User("12345", "login", "Allex");
        User user2 = new User("12345", "login", "Allex");
        User user3 = new User("12345", "login2", "Allex");
        User user4 = new User("123", "no_login", "Allexander");

        System.out.println(user1);
        System.out.println();

        //userService.registerUser(user2);

        //System.out.println(userService.registerUser(user1));




        user1 = userService.login("No login", "12345");
        user1.setName("Alex");
        userService.updateUser(user1);


        System.out.println(user1);



        System.out.println(userService.addRecipe(recipe2,user1));

        List<Recipe> recipeList = userService.getAllRecipeUser(user1);
        for (Recipe recipe : recipeList) {
            System.out.println(recipe);
            System.out.println();
        }




    }
}
