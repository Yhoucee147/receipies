
package presenter;

import model.Recipe;
import model.RecipeDAO;
import view.MenuView;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;


public class Presenter {
    
    MenuView view;
    RecipeDAO recipedao;
    
    public Presenter(MenuView view, RecipeDAO recipedao){
        this.view = view;
        this.recipedao = recipedao;
    }
    
    public void addRecipe(Recipe recipe){
        
        String response ;
        try{
            recipedao.addNewRecipe(recipe);
            response = "Recipe added Successfully";
            view.updateStatusField(response);
        }catch(SQLException e){
            response = "Failed to add recipe, Please check logs";
            System.out.println("Error : " + e.getMessage());
            view.updateStatusField(response);
        }
        
    }
    
    public void allRecipesForPrepRange(String category, int upBound, int lwBound){
         try{
            List<Recipe> allRecipes = recipedao.allRecipesForGivenPrepRange(category, upBound, lwBound);
            view.updateDataField(allRecipes);
        }catch(SQLException e){
             System.out.println("Error : " + e.getMessage());
             JOptionPane.showMessageDialog(view, "Failed to retrieve data, Please check logs");
        }
    }
    
    public void allRecipesForCombRange(String category, int upBound, int lwBound){
         try{
            List<Recipe> allRecipes = recipedao.allRecipesForGivenCombRange(category, upBound, lwBound);
            view.updateDataField(allRecipes);
        }catch(SQLException e){
            System.out.println("Error : " + e.getMessage());
            JOptionPane.showMessageDialog(view, "Failed to retrieve data, Please check logs");
        }
    }
    
    public void allRecipesForCategory(String category){
        try{
            List<Recipe> allRecipes = recipedao.allRecipesForCategory(category);
            view.updateDataField(allRecipes);
        }catch (SQLException e){
             System.out.println("Error : " + e.getMessage());
            JOptionPane.showMessageDialog(view, "Failed to retrieve data, Please check logs");
        }
    }
    
    public void countForIngredient(String ingredient){
        try{
            int count = recipedao.countForIngredients(ingredient);
            view.updateStatusField(String.valueOf(count));
        }catch(SQLException e){
            System.out.println("Error : " + e.getMessage());
            view.updateStatusField("Failed to retrieve value from records, Please check logs");
        }
    }
    
    public void clearFields(){
        view.resetPage();
    }
    
}
