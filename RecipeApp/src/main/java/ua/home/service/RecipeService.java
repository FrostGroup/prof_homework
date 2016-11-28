package ua.home.service;

import ua.home.model.Recipe;
import ua.home.model.User;

import java.util.List;

/**
 * Created by Alex on 21.10.2016.
 */
public interface RecipeService {

    Recipe addRecipe(Recipe recipe);

    Recipe removeRecipe(Recipe recipe);

    List<Recipe> getAllRecipes();

    Recipe foundRecipe(String word);

    boolean addUser(User user);

}
