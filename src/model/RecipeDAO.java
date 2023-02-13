
package model;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;


public class RecipeDAO implements IRecipe{
    
    String driver;
    String url;
    
    public RecipeDAO(){
        activateDBConnection();
    }

    @Override
    public void addNewRecipe(Recipe recipe) throws SQLException{
        Connection con = DriverManager.getConnection(url,"app","app");
        String sql = "INSERT INTO RECIPES (RECIPENAME,CATEGORY,MAININGREDIENT,PREPARATIONTIME,COOKINGTIME) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, recipe.getRecipeName());
        stmt.setString(2, recipe.getCategory());
        stmt.setString(3, recipe.getMainIngridient());
        stmt.setInt(4, recipe.getPreparationTime());
        stmt.setInt(5, recipe.getCookingTime());
        stmt.execute();
    }

    @Override
    public List<Recipe> allRecipesForGivenPrepRange(String category, int upBound, int lwBound) throws SQLException{
        List<Recipe> allForPrepRange = new ArrayList<>();
        Connection con = DriverManager.getConnection(url,"app", "app");
        String sql = "SELECT * FROM RECIPES WHERE CATEGORY = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, category);
        ResultSet rst = stmt.executeQuery();
        while(rst.next()){
            if ((rst.getInt("PREPARATIONTIME") >= lwBound) && rst.getInt("PREPARATIONTIME") <= upBound){
                Recipe recipe = new Recipe();
            recipe.setId(rst.getInt("ID"));
            recipe.setRecipeName(rst.getString("RECIPENAME"));
            recipe.setCategory(rst.getString("CATEGORY"));
            recipe.setMainIngridient(rst.getString("MAININGREDIENT"));
            recipe.setPreparationTime(rst.getInt("PREPARATIONTIME"));
            recipe.setCookingTime(rst.getInt("COOKINGTIME"));
            allForPrepRange.add(recipe);
            }
        }
        return allForPrepRange;
    }

    @Override
    public List<Recipe> allRecipesForGivenCombRange(String category, int upBound, int lwBound) throws SQLException{
        List<Recipe> allForCombRange = new ArrayList<>();
        Connection con = DriverManager.getConnection(url,"root", "root");
        String sql = "SELECT * FROM RECIPES WHERE CATEGORY = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, category);
        ResultSet rst = stmt.executeQuery();
        while(rst.next()){
            int combTime = rst.getInt("PREPARATIONTIME") + rst.getInt("COOKINGTIME");
            if ((combTime >= lwBound) && (combTime <= upBound)){
                Recipe recipe = new Recipe();
            recipe.setId(rst.getInt("ID"));
            recipe.setRecipeName(rst.getString("RECIPENAME"));
            recipe.setCategory(rst.getString("CATEGORY"));
            recipe.setMainIngridient(rst.getString("MAININGREDIENT"));
            recipe.setPreparationTime(rst.getInt("PREPARATIONTIME"));
            recipe.setCookingTime(rst.getInt("COOKINGTIME"));
            allForCombRange.add(recipe);
            }
        }
        return allForCombRange;
    }

    @Override
    public List<Recipe> allRecipesForCategory(String category) throws SQLException{
        List<Recipe> allForCategory = new ArrayList<>();
        Connection con = DriverManager.getConnection(url,"app", "app");
        String sql = "SELECT * FROM RECIPES WHERE CATEGORY = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, category);
        ResultSet rst = stmt.executeQuery();
        while(rst.next()){
            Recipe recipe = new Recipe();
            recipe.setId(rst.getInt("ID"));
            recipe.setRecipeName(rst.getString("RECIPENAME"));
            recipe.setCategory(rst.getString("CATEGORY"));
            recipe.setMainIngridient(rst.getString("MAININGREDIENT"));
            recipe.setPreparationTime(rst.getInt("PREPARATIONTIME"));
            recipe.setCookingTime(rst.getInt("COOKINGTIME"));
            allForCategory.add(recipe);
        }
        return allForCategory;
    }
    
    public final void activateDBConnection(){
        this.driver = "org.apache.derby.jdbc.ClientDriver";
        this.url = "jdbc:derby://localhost:1527/xyz";
    }
    
    
    @Override
    public int countForIngredients(String ingredients) throws SQLException{
        Connection con = DriverManager.getConnection(url,"app", "app");
        String sql = "SELECT COUNT(*) FROM RECIPES WHERE MAININGREDIENT = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, ingredients);
        ResultSet rst = stmt.executeQuery();
        rst.next();
        int count = rst.getInt(1);
        return count;
    }
    
}
