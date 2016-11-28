package ua.home.dao;

import ua.home.exception.NoRecipeException;
import ua.home.model.Recipe;

import java.util.List;

/**
 * Created by Alex on 23.08.2016.
 */
public interface RecipeDao {

    List<Recipe> getAllRecipeList();

    Recipe findRecipeByName(String name);

    List<Recipe> findRecipeByIngredients(String ingredients);
    
    Recipe addRecipe(Recipe recipe);
    
    Recipe removeRecipe(Recipe recipe);

    Recipe updateRecipe(Recipe recipeUp);
    
}
