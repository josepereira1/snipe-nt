package menus.menus;

import business.SnipeNobleTrain;
import exceptions.SnipeNotExistsException;
import menus.Menu;
import utils.Utils;

import java.util.Scanner;

public class RemoveSnipe implements Menu {

    private SnipeNobleTrain snipeNobleTrain;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the snipe name of the list to remove:");
        Utils.displayPrefix();
        String index = scanner.nextLine();
        try {
            snipeNobleTrain.removeSnipe(index);
        } catch (SnipeNotExistsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("OUTPUT:\n" + snipeNobleTrain.snipesToString());
    }

    @Override
    public void setSnipeNobleTrain(SnipeNobleTrain snipeNobleTrain) {
        this.snipeNobleTrain = snipeNobleTrain;
    }
}
