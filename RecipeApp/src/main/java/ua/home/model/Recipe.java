package ua.home.model;

import java.util.List;

/**
 * Created by Alex on 23.08.2016.
 */
public class Recipe {

    private String name;
    private List<String> ingredients;
    private String cookingMethod;

    public Recipe() {
    }

    public Recipe(String name, String cookingMethod) {
        this.name = name;
        this.cookingMethod = cookingMethod;
    }

    public Recipe(String name, List<String> ingredients, String cookingMethod) {
        this.name = name;
        this.ingredients = ingredients;
        this.cookingMethod = cookingMethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getCookingMethod() {
        return cookingMethod;
    }

    public void setCookingMethod(String cookingMethod) {
        this.cookingMethod = cookingMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (name != null ? !name.equals(recipe.name) : recipe.name != null) return false;
        if (ingredients != null ? !ingredients.equals(recipe.ingredients) : recipe.ingredients != null) return false;
        return cookingMethod != null ? cookingMethod.equals(recipe.cookingMethod) : recipe.cookingMethod == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (ingredients != null ? ingredients.hashCode() : 0);
        result = 31 * result + (cookingMethod != null ? cookingMethod.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", cookingMethod='" + cookingMethod + '\'' +
                '}';
    }
}
