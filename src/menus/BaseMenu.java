package menus;

import business.SnipeNobleTrain;
import menus.menus.*;
import utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BaseMenu implements Menu{

    private static final Map<String, Menu> menus;

    static {
        menus = new HashMap<>();
        menus.put("help", new HelpMenu());
        menus.put("add", new AddSnipeMenu());
        menus.put("list", new ListSnipesMenu());
        menus.put("remove", new RemoveSnipe());
        menus.put("reset", new ResetSnipesMenu());
    }

    private SnipeNobleTrain snipeNobleTrain;

    @Override
    public void setSnipeNobleTrain(SnipeNobleTrain snipeNobleTrain) {
        this.snipeNobleTrain = snipeNobleTrain;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to SnipeNT, an application to easily calculate the times to snipe noble trains.");
        System.out.println("Type \"help\" to see the commands.");
        boolean conditional =  Boolean.TRUE;
        do {
            System.out.print(Utils.PREFIX);
            try {
                conditional = selectAndExecuteMenu(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Something went wrong, follow the instructions, try again.");
            }
        } while (conditional);
    }

    private Boolean selectAndExecuteMenu(String command) {
        command = command.toLowerCase();
        if(menus.containsKey(command)) {
            Menu menu = menus.get(command);
            menu.setSnipeNobleTrain(snipeNobleTrain);
            menu.execute();
        } else if(command.equals("exit")) {
           return false;
        } else {
            System.out.println("OUTPUT:\nCommand not recognize, use help for more information.");
        }
        return true;
    }
}
