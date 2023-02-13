
package model;

import java.util.List;
import java.sql.*;


public interface IRecipe {
    public void addNewRecipe(Recipe recipe) throws SQLException;
    public List<Recipe> allRecipesForGivenPrepRange(String Category, int upBound, int lwBound) throws SQLException;
    public List<Recipe> allRecipesForGivenCombRange(String Category, int upBound, int lwBound) throws SQLException;
    public List<Recipe> allRecipesForCategory(String category) throws SQLException;
    public int countForIngredients(String ingredients) throws SQLException;
}
