package ua.home.dao;

import ua.home.exception.NoRecipeException;
import ua.home.model.Recipe;

import java.util.List;

/**
 * Created by Alex on 23.08.2016.
 */
public interface RecipeDao {

    List<Recipe> showRecipeList();

    Recipe findRecipeByName(String name);

    Recipe findRecipeByIngredients(List<String> ingredients);

}
