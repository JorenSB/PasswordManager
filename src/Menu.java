import java.util.ArrayList;
import java.util.Comparator;

abstract class Menu {
    ArrayList<MenuAble> items;
    Menu() {
        items = new ArrayList<>();
    }
    abstract public void printMenuNaam();
    public void printMenu() {
        printMenuNaam();
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
        items.add(new PasswordsMenuItem("View passwords"));
        items.add(new PasswordAddMenuItem("Add a password"));
        items.add(new GeneratePasswordWithLengthItem("Generate password"));
        items.add(new ExitItem("Exit"));
        printMenu();
    }

    @Override
    public void printMenuNaam() {
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
        items.add(new MainMenuItem("Main Menu"));
        items.add(new ExitItem("Exit"));
        printMenu();
    }
    @Override
    public void printMenuNaam() {
        System.out.println("Password View Menu:");
    }
}
class PassView extends Menu {
    public void startMenu(Password p) {
        System.out.printf("Name: %s\nUsername: %s\nPassword: %s\nUrl: %s\n", p.getName(), p.getUsername(), p.getPassword(), p.getUrl());
        items.add(new DeletePasswordItem("Delete Password", p));
        items.add(new AnalyzePasswordItem("Analyze password", p));
        items.add(new PasswordsMenuItem("Back"));
        items.add(new MainMenuItem("Main Menu"));
        items.add(new ExitItem("Exit"));
        printMenu();
    }
    @Override
    public void printMenuNaam() {
        System.out.println("Password Information Menu:");
    }
}
