package ua.home.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.home.exception.RegisterException;
import ua.home.model.Recipe;
import ua.home.model.User;
import ua.home.service.UserService;
import ua.home.service.UserServiceImpl;

import java.util.List;

/**
 * Created by Alex on 23.11.2016.
 */
public class TestSpring {
    public static void main(String[] args) throws RegisterException {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/spring-context.xml");
        UserService userService = applicationContext.getBean(UserService.class);

        //userService.registerUser(new User("123pass", "login123", "Alexxx"));

        User myUser = userService.findUser("No login");

        /*Recipe recipe = new Recipe("nameeeee", "1, 2 , 3", "hhhhhh");
        userService.makeNewRecipe(recipe);
*/
        List<Recipe> recipeList = userService.foundRecipe("last");

        for (Recipe recipe1 : recipeList) {
            System.out.println(recipe1);
        }

        userService.addRecipe(recipeList.get(1), myUser);

    }
}
