package menus.menus;

import business.SnipeNobleTrain;
import menus.Menu;
import utils.Utils;

import java.util.Scanner;

public class ResetSnipesMenu implements Menu {

    private SnipeNobleTrain snipeNobleTrain;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure to reset the snipes? Y or N?");
        Utils.displayPrefix();
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            snipeNobleTrain.resetSnipes();
        }
        System.out.println("OUTPUT:\n" + snipeNobleTrain.snipesToString());
    }

    @Override
    public void setSnipeNobleTrain(SnipeNobleTrain snipeNobleTrain) {
        this.snipeNobleTrain = snipeNobleTrain;
    }
}
