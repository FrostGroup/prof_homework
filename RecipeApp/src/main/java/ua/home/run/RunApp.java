package ua.home.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.home.dao.*;
import ua.home.exception.RegisterException;
import ua.home.model.Recipe;
import ua.home.model.User;
import ua.home.service.UserService;
import ua.home.service.UserServiceImpl;
import ua.home.service.Validator;
import ua.home.service.ValidatorImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 19.09.2016.
 */
public class RunApp {
    public static void main(String[] args) throws RegisterException {


        RecipeDao recipeDao = new RecipeDaoImpl();
        UserDao userDao = new UserDaoImpl();
        Validator validator = new ValidatorImpl(userDao, recipeDao);
        UserService userService = new UserServiceImpl(validator, recipeDao, userDao);



        Recipe recipe1 = new Recipe("somesing", "first second last", "tuch all");
        Recipe recipe3 = new Recipe("tuch all", "first second last", "8888888");
        Recipe recipe2 = new Recipe("somesing2", "first second last2", "tuch all2");
        User user1 = new User("12345", "login", "Allex");
        User user2 = new User("12345", "login", "Allex");
        User user3 = new User("12345", "login2", "Allex");
        User user4 = new User("123", "no_login", "Allexander");


        System.out.println(userService.makeNewRecipe(recipe1).toString());
        System.out.println(userService.makeNewRecipe(recipe2).toString());
        System.out.println(userService.makeNewRecipe(recipe3).toString());

        System.out.println(userService.registerUser(user1));



        List<Recipe> listRecipe = userService.foundRecipe("tuch all");
        int i = 1;
        for (Recipe recipe : listRecipe) {
            System.out.println(recipe);
            System.out.println(i++);
        }

        boolean res = userService.addRecipe(recipe2, user1);
        userService.addRecipe(recipe1, user1);
        userService.addRecipe(recipe3, user1);

        System.out.println(res);

        List<Recipe> recipeList = userService.getAllRecipeUser(user1);
        for (Recipe recipe : recipeList) {
            System.out.println(recipe);
            System.out.println();
        }


        System.out.println(userService.registerUser(user3));

        user1.setName("Alexander");
        user1.setLogin("no_login");
        System.out.println(userService.updateUser(user3));
        System.out.println(userService.removeRecipe(recipe3, user1));



    }
}
