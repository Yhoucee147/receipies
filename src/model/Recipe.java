
package model;


public class Recipe {
    
    private int id;
    private String recipeName;
    private String category;
    private String mainIngridient;
    private int preparationTime;
    private int cookingTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getMainIngridient() {
        return mainIngridient;
    }

    public void setMainIngridient(String mainIngridient) {
        this.mainIngridient = mainIngridient;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    @Override
    public String toString() {
        return "Recipe{" + "id=" + id + ", recipeName=" + recipeName + ", mainIngridient=" + mainIngridient + ", preparationTime=" + preparationTime + ", cookingTime=" + cookingTime + '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
}
