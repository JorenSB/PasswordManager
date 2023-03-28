import java.util.ArrayList;
import java.util.Comparator;

abstract class Menu {
    ArrayList<MenuAble> items;
    Menu() {
        items = new ArrayList<>();
    }
    public void PrintMenu() {
        int index = 1;
        for (MenuAble item : items) {
            System.out.printf("%d : %s\n", index, item.getName());
            index++;
        }
        items.get(Connector.GetIntInput(items.size())-1).Execute();
    }
}
class MainMenu extends Menu {
    public void StartMenu() {
        items.add(new PasswordsMenuItem("View passwords"));
        items.add(new PasswordAddMenuItem("Add a password"));
        items.add(new GeneratePasswordWithLengthItem("Generate password"));
        items.add(new ExitItem("Exit"));
        PrintMenu();
    }
}
class PassMenu extends Menu {
    public void StartMenu() {
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
        PrintMenu();
    }
}
class PassView extends Menu {
    public void StartMenu(Password p) {
        System.out.printf("%s\n%s\n%s\n%s\n", p.getName(), p.getUsername(), p.getPassword(), p.getUrl());
        items.add(new DeletePasswordItem("Delete Password", p));
        items.add(new PasswordsMenuItem("Back"));
        items.add(new MainMenuItem("Main Menu"));
        items.add(new ExitItem("Exit"));
        PrintMenu();
    }
}
