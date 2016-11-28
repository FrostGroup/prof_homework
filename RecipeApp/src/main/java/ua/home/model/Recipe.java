package ua.home.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "recipes")
@NamedQueries({@NamedQuery(name = "getAllRecipes", query = "SELECT c FROM Recipe c")})
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "CONFORMITY")
    private int conformity = 0;
    @Column(name = "NAME")
    private String name;
    @Column(name = "INGREDIENTS")
    private String ingredients;
    @Column(name = "COOKING_METHOD")
    private String cookingMethod;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "recipeList")
    private List<User> userList = new ArrayList<>();

    public Recipe() {
    }

    public Recipe(String name, String ingredients, String cookingMethod) {
        this.name = name;
        this.ingredients = ingredients;
        this.cookingMethod = cookingMethod;
    }


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConformity() {
        return conformity;
    }

    public void setConformity(int conformity) {
        this.conformity = conformity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getCookingMethod() {
        return cookingMethod;
    }

    public void setCookingMethod(String cookingMethod) {
        this.cookingMethod = cookingMethod;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", conformity=" + conformity +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", cookingMethod='" + cookingMethod + '\'' +
                /*", userList=" + userList +*/
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        return id == recipe.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
