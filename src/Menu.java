import java.util.ArrayList;

abstract class Menu {
    ArrayList<MenuAble> items;
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
        items.get(UserInput.getIntInput(items.size())-1).execute();
    }
}
class MainMenu extends Menu {
    public void startMenu() {
        items.add(new PasswordsMenuItem("View passwords"));
        items.add(new PasswordAddMenuItem("Add a password"));
        items.add(new PasswordToolsMenuItem("Password Tools"));
        items.add(new ExitItem("Exit"));
        printMenu();
    }

    @Override
    public void printMenuName() {
        System.out.println("Main Menu:");
    }
}
class PassMenu extends Menu {
    public void startMenu() {
        if (PasswordList.getPasswords() != null && PasswordList.getPasswords().size() > 0) {
            System.out.println("Saved Passwords:");
            items.addAll(PasswordList.getPasswords());
        }
        else {
            System.out.println("No Passwords Saved.");
        }
        items.add(new MainMenuItem("Main Menu"));
        items.add(new ExitItem("Exit"));
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
        items.add(new DeletePasswordItem("Delete Password", p));
        items.add(new AnalyzePasswordItem("Analyze password", p.getPassword()));
        items.add(new PasswordsMenuItem("Back"));
        items.add(new MainMenuItem("Main Menu"));
        items.add(new ExitItem("Exit"));
        printMenu();
    }
    @Override
    public void printMenuName() {
        System.out.println("Password Information Menu:");
    }
}


class PassToolsMenu extends Menu {
    public void startMenu() {
        items.add(new GeneratePasswordWithLengthItem("Generate Password"));
        items.add(new AnalyzePasswordItem("Analyze Password"));
        items.add(new MainMenuItem("Main Menu"));
        items.add(new ExitItem("Exit"));
        printMenu();
    }
    @Override
    public void printMenuName() {
        System.out.println("Password Tools Menu:");
    }
}
