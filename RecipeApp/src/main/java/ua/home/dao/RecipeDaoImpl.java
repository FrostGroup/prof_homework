package ua.home.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.home.exception.NoRecipeException;
import ua.home.model.Recipe;
import ua.home.utils.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

@Component
public class RecipeDaoImpl implements RecipeDao {

    @PersistenceContext
    private EntityManager manager;


    @Override
    @Transactional
    public List<Recipe> getAllRecipeList() {
        Query query = manager.createNamedQuery("getAllRecipes");
        List<Recipe> recipeList = query.getResultList();
        return recipeList;
    }

    @Override
    public Recipe findRecipeByName(String name) {
        Recipe recipe = null;
        List<Recipe> recipeList = getAllRecipeList();
        for (Recipe recipe1 : recipeList) {
            if (recipe1.getName().equals(name)){
                recipe = recipe1;
                break;
            }
        }

        return recipe;
    }

    @Override
    public List<Recipe> findRecipeByIngredients(String ingredients) {
        if(ingredients == null){
            return null;
        }
        List<Recipe> recipeList = new ArrayList<>();
        List<Recipe> allRecipe = getAllRecipeList();
        String[] ingArray = ingredients.split("[ ,.]");

        for (Recipe recipe : allRecipe) {
            int conformity = 0;
            for (String s : ingArray) {
                if(!s.equals("") && recipe.getIngredients().contains(s)){
                    recipe.setConformity(++conformity);
                }
            }
            if(recipe.getConformity() > 0)
                recipeList.add(recipe);
        }
        return recipeList;
    }

    @Override
    @Transactional
    public Recipe addRecipe(Recipe recipe) {
        manager.persist(recipe);
        return recipe;
    }

    @Override
    @Transactional
    public Recipe removeRecipe(Recipe recipe){
        Recipe res = null;
        if(recipe == null){
            return res;
        }
        res = manager.find(Recipe.class, recipe);
        manager.remove(res);
        return res;
    }

    @Override
    public Recipe updateRecipe(Recipe recipeUp) {
        Recipe res = null;
        for (Recipe recipe : getAllRecipeList()) {
            if(recipe.getName().equals(recipeUp.getName())){
                recipe = recipeUp;
                res = recipe;
                break;
            }
        }
        return res;
    }
}
