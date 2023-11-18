package menus.menus;

import business.SnipeNobleTrain;
import menus.Menu;

public class ListSnipesMenu implements Menu {

    private SnipeNobleTrain snipeNobleTrain;

    public ListSnipesMenu() {

    }

    @Override
    public void execute() {
        System.out.println("OUTPUT: \n" + snipeNobleTrain.snipesToString());
    }

    @Override
    public void setSnipeNobleTrain(SnipeNobleTrain snipeNobleTrain) {
        this.snipeNobleTrain = snipeNobleTrain;
    }
}
