package menus.menus;

import business.SnipeNobleTrain;
import menus.Menu;

public class HelpMenu implements Menu {

    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Name: SnipeNT").append("\n")
                .append("Description: Welcome to SnipeNT an application to easily calculate the times to snipe noble trains.").append("\n")
                .append("version: v1.0").append("\n\n\n")
                .append("COMMANDS:").append("\n")
                .append("add:    ").append("Add a new snipe to the list;").append("\n")
                .append("help:   ").append("Display this information;").append("\n")
                .append("list:   ").append("List the snipes;").append("\n")
                .append("remove: ").append("Remove a specific snipe by name;").append("\n")
                .append("reset:  ").append("Reset the list;\n\n")
                .append("Copyright: @josepereira1 @GitHub (https://github.com/josepereira1/snipe-nt)")
        ;
        System.out.println(sb);
    }

    @Override
    public void setSnipeNobleTrain(SnipeNobleTrain snipeNobleTrain) {

    }
}
