import java.util.ArrayList;

abstract class Menu implements MenuAble {
    private final String MENU_NAME;
    protected ArrayList<MenuAble> items;
    protected Menu(String name) {
        this.MENU_NAME = name;
        items = new ArrayList<>();
    }

    abstract public void printMenuName();

    @Override
    public String getName() {
        return MENU_NAME;
    }

    @Override
    public void execute() {
        printMenuName();
        int index = 1;
        for (MenuAble item : items) {
            System.out.printf("%d : %s\n", index, item.getName());
            index++;
        }
        items.get(UserInput.getIntInput(items.size())-1).execute();
    }
}
abstract class MenuWithPasswordListAndPasswordToolsFactory extends Menu {
    protected PasswordList PASSWORD_LIST;
    protected PasswordToolsFactory PASSWORD_TOOLS_FACTORY;
    MenuWithPasswordListAndPasswordToolsFactory(String name, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name);
        this.PASSWORD_LIST = passwordList;
        this.PASSWORD_TOOLS_FACTORY = passwordToolsFactory;
    }
}
class MainMenu extends MenuWithPasswordListAndPasswordToolsFactory {
    MainMenu(String name, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name, passwordList, passwordToolsFactory);
        items.add(new PasswordsViewMenu("View passwords", PASSWORD_LIST, PASSWORD_TOOLS_FACTORY));
        items.add(new AddPasswordItem("Add a password", PASSWORD_LIST, PASSWORD_TOOLS_FACTORY));
        items.add(new PasswordToolsMenu("Password Tools", PASSWORD_LIST, PASSWORD_TOOLS_FACTORY));
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
        if (PASSWORD_LIST.getPasswords().size() > 0) {
            for (Password password : PASSWORD_LIST.getPasswords()) {
                items.add(new PasswordItem(password.getName(), password, PASSWORD_LIST, PASSWORD_TOOLS_FACTORY));
            }
        }
        items.add(new MainMenuItem("Main Menu", PASSWORD_LIST, PASSWORD_TOOLS_FACTORY));
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
        items.add(new GeneratePasswordWithLengthItem("Generate Password", PASSWORD_LIST ,PASSWORD_TOOLS_FACTORY));
        items.add(new AnalyzePasswordItem("Analyze Password", PASSWORD_LIST, PASSWORD_TOOLS_FACTORY));
        items.add(new MainMenuItem("Main Menu", PASSWORD_LIST, PASSWORD_TOOLS_FACTORY));
        items.add(new ExitItem("Exit"));
    }

    @Override
    public void printMenuName() {
        System.out.println("Password Tools Menu:");
    }
}
class PasswordInformationMenu extends MenuWithPasswordListAndPasswordToolsFactory {
    PasswordInformationMenu(String name, Password password, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name, passwordList, passwordToolsFactory);
        System.out.printf("Name: %s\nUsername: %s\nPassword: %s\nUrl: %s\n", password.getName(), password.getUsername(), password.getPassword(), password.getUrl());
        items.add(new DeletePasswordItem("Delete Password", password, PASSWORD_LIST, PASSWORD_TOOLS_FACTORY));
        items.add(new AnalyzePasswordItem("Analyze password", password.getPassword(), PASSWORD_LIST, PASSWORD_TOOLS_FACTORY));
        items.add(new PasswordsViewMenu("Back", PASSWORD_LIST, PASSWORD_TOOLS_FACTORY));
        items.add(new MainMenuItem("Main Menu", PASSWORD_LIST, PASSWORD_TOOLS_FACTORY));
        items.add(new ExitItem("Exit"));
    }

    @Override
    public void printMenuName() {
        System.out.println("Password Information Menu:");
    }
}
