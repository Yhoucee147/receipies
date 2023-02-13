
package view;

import java.util.List;
import model.Recipe;
import presenter.Presenter;

public interface MenuViewI {
    public void setPresenter(Presenter pres);
    public void updateStatusField(String text);
    public void updateDataField(List<Recipe> recipes);
}
