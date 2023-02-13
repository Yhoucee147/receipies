
package recipes;

import javax.swing.SwingUtilities;
import model.RecipeDAO;
import presenter.Presenter;
import view.MenuView;


public class Recipes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuView menuView = new MenuView();
            menuView.setPresenter(new Presenter(menuView, new RecipeDAO()));
            menuView.setVisible(true);
        });

    }
    
}
