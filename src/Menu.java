import java.util.ArrayList;
import java.util.Comparator;

abstract class Menu {
    ArrayList<MenuAble> items;
    MenuAbleFactory menuAbleFactory = new MenuAbleFactory();
    Menu() {
        items = new ArrayList<>();
    }
    abstract public void printMenuName();
    public void printMenu() {
        printMenuName();
        int index = 1;
        for (MenuAble item : items) {
            System.out.printf("%d : %s\n", index, item.getName());
            index++;
        }
        items.get(Connector.getIntInput(items.size())-1).execute();
    }

}
class MainMenu extends Menu {
    public void startMenu() {

        items.add(menuAbleFactory.getMenuAble("PasswordsMenuItem", "View passwords"));
        items.add(menuAbleFactory.getMenuAble("PasswordAddMenuItem", "Add a password"));
        items.add(menuAbleFactory.getMenuAble("GeneratePasswordWithLengthItem", "Generate password"));
        items.add(menuAbleFactory.getMenuAble("ExitItem", "Exit"));
        printMenu();
    }

    @Override
    public void printMenuName() {
        System.out.println("Main Menu:");
    }
}
class PassMenu extends Menu {
    public void startMenu() {
        if (Connector.passwords != null && Connector.passwords.size() > 0) {
            System.out.println("Saved Passwords:");
            Connector.passwords.sort(Comparator.comparing(Password::getName));
            items.addAll(Connector.passwords);
        }
        else {
            System.out.println("No Passwords Saved.");
        }
        items.add(menuAbleFactory.getMenuAble("MainMenuItem", "Main Menu"));
        items.add(menuAbleFactory.getMenuAble("ExitItem", "Exit"));
        printMenu();
    }
    @Override
    public void printMenuName() {
        System.out.println("Password View Menu:");
    }
}
class PassView extends Menu {
    public void startMenu(Password p) {
        System.out.printf("Name: %s\nUsername: %s\nPassword: %s\nUrl: %s\n", p.getName(), p.getUsername(), p.getPassword(), p.getUrl());
        items.add(menuAbleFactory.getMenuAble("DeletePasswordItem", "Delete Password", p));
        items.add(menuAbleFactory.getMenuAble("AnalyzePasswordItem", "Analyze password", p));
        items.add(menuAbleFactory.getMenuAble("PasswordsMenuItem", "Back"));
        items.add(menuAbleFactory.getMenuAble("MainMenuItem", "Main Menu"));
        items.add(menuAbleFactory.getMenuAble("ExitItem", "Exit"));
        printMenu();
    }
    @Override
    public void printMenuName() {
        System.out.println("Password Information Menu:");
    }
}
