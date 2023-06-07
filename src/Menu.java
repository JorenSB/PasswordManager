import java.util.ArrayList;

abstract class Menu implements MenuAble {
    String menuName;
    ArrayList<MenuAble> items;
    Menu(String name) {
        this.menuName = name;
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

    @Override
    public String getName() {
        return menuName;
    }
    @Override
    public void execute() {
        printMenu();
    }
}
abstract class MenuWithPasswordListAndPasswordToolsFactory extends Menu {
    PasswordList passwordList;
    PasswordToolsFactory passwordToolsFactory;
    MenuWithPasswordListAndPasswordToolsFactory(String name, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name);
        this.passwordList = passwordList;
        this.passwordToolsFactory = passwordToolsFactory;
    }
}
class MainMenu extends MenuWithPasswordListAndPasswordToolsFactory {
    MainMenu(String name, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name, passwordList, passwordToolsFactory);
        items.add(new PasswordsViewMenu("View passwords", passwordList, passwordToolsFactory));
        items.add(new PasswordAddItem("Add a password", passwordList, passwordToolsFactory));
        items.add(new PasswordToolsMenu("Password Tools", passwordList, passwordToolsFactory));
        items.add(new ExitItem("Exit"));
    }
    @Override
    public void printMenuName() {
        System.out.println("Main Menu:");
    }
}
class PasswordsViewMenu extends MenuWithPasswordListAndPasswordToolsFactory {
    PasswordsViewMenu(String name, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name, passwordList, passwordToolsFactory);
        if (passwordList.getPasswords().size() > 0) {
            System.out.println("Saved Passwords:");
            for (Password password : passwordList.getPasswords()) {
                items.add(new PasswordItem(password.getName(), password, passwordList, passwordToolsFactory));
            }
        } else {
            System.out.println("No Passwords Saved.");
        }
        items.add(new MainMenu("Main Menu", passwordList, passwordToolsFactory));
        items.add(new ExitItem("Exit"));
    }
    @Override
    public void printMenuName() {
        System.out.println("Password View Menu:");
    }
}
class PasswordToolsMenu extends MenuWithPasswordListAndPasswordToolsFactory {
    PasswordToolsMenu(String name, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name, passwordList, passwordToolsFactory);
        items.add(new GeneratePasswordWithLengthItem("Generate Password", passwordList ,passwordToolsFactory));
        items.add(new AnalyzePasswordItem("Analyze Password", passwordList, passwordToolsFactory));
        items.add(new MainMenu("Main Menu", passwordList, passwordToolsFactory));
        items.add(new ExitItem("Exit"));
    }
    @Override
    public void printMenuName() {
        System.out.println("Password Tools Menu:");
    }
}
class PasswordInformationMenu extends MenuWithPasswordListAndPasswordToolsFactory {
    Password password;
    PasswordInformationMenu(String name, Password password, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name, passwordList, passwordToolsFactory);
        this.password = password;
        System.out.printf("Name: %s\nUsername: %s\nPassword: %s\nUrl: %s\n", password.getName(), password.getUsername(), password.getPassword(), password.getUrl());
        items.add(new DeletePasswordItem("Delete Password", password, passwordList, passwordToolsFactory));
        items.add(new AnalyzePasswordItem("Analyze password", password.getPassword(), passwordList, passwordToolsFactory));
        items.add(new PasswordsViewMenu("Back", passwordList, passwordToolsFactory));
        items.add(new MainMenu("Main Menu", passwordList, passwordToolsFactory));
        items.add(new ExitItem("Exit"));
    }
    @Override
    public void printMenuName() {
        System.out.println("Password Information Menu:");
    }
}
