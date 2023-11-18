import business.SnipeNobleTrain;
import menus.BaseMenu;

public class Main {

    public static void main(String[] args) {
        SnipeNobleTrain snipeNobleTrain = new SnipeNobleTrain();
        BaseMenu homeMenu = new BaseMenu();
        homeMenu.setSnipeNobleTrain(snipeNobleTrain);
        homeMenu.execute();
    }
}
