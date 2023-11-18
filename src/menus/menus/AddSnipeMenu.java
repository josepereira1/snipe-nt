package menus.menus;

import business.SnipeNobleTrain;
import exceptions.SurpassedTheMaxTimeToCancelAttacksOrSupport;
import menus.Menu;
import utils.Utils;

import java.util.Scanner;

public class AddSnipeMenu implements Menu {

    private static final String DELIMITER = ":";

    private SnipeNobleTrain snipeNobleTrain;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert a name to the snipe: ");
        Utils.displayPrefix();
        String name = scanner.nextLine();
        if(snipeNobleTrain.snipeAlreadyExists(name)) {
            System.out.println(String.format("Snipe with name \"%s\" already exists.", name));
            return;
        }
        System.out.println("Insert the max time to cancel an attack or support (in minutes):");
        Utils.displayPrefix();
        String maxTime = scanner.nextLine();
        System.out.println("Insert attack time \"HH" + DELIMITER + "MM" + DELIMITER + "SS\":");
        Utils.displayPrefix();
        String attackDateInput = scanner.nextLine();
        System.out.println("Insert troops out time \"HH" + DELIMITER + "MM" + DELIMITER + "SS\":");
        Utils.displayPrefix();
        String troopsOutDateInput = scanner.nextLine();
        String[] troopsOutDate = troopsOutDateInput.split(DELIMITER);
        Integer h1 = Integer.valueOf(troopsOutDate[0]);
        Integer m1 = Integer.valueOf(troopsOutDate[1]);
        Integer s1 = Integer.valueOf(troopsOutDate[2]);
        String[] attackDate = attackDateInput.split(DELIMITER);
        Integer h2 = Integer.valueOf(attackDate[0]);
        Integer m2 = Integer.valueOf(attackDate[1]);
        Integer s2 = Integer.valueOf(attackDate[2]);
        try {
            snipeNobleTrain.addSnipe(name, Utils.convertToLocalDateTime(h1, m1, s1), Utils.convertToLocalDateTime(h2, m2, s2), Integer.valueOf(maxTime));
        } catch (SurpassedTheMaxTimeToCancelAttacksOrSupport e) {
            System.out.println(e.getMessage());
        }
        System.out.println("OUTPUT: \n" + snipeNobleTrain.snipesToString());
    }

    @Override
    public void setSnipeNobleTrain(SnipeNobleTrain snipeNobleTrain) {
        this.snipeNobleTrain = snipeNobleTrain;
    }
}
