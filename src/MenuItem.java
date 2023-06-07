abstract class MenuItem implements MenuAble {
    private final String name;
    public MenuItem(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    abstract public void execute();

}
abstract class MenuItemWithPasswordListAndPasswordToolsFactory extends MenuItem {
    PasswordToolsFactory passwordToolsFactory;
    PasswordList passwordList;
    public MenuItemWithPasswordListAndPasswordToolsFactory(String name, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name);
        this.passwordList = passwordList;
        this.passwordToolsFactory = passwordToolsFactory;
    }
}
class PasswordAddItem extends MenuItemWithPasswordListAndPasswordToolsFactory {
    public PasswordAddItem(String name, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name, passwordList, passwordToolsFactory);
    }
    @Override
    public void execute() {
        System.out.println("Name: ");
        String name = UserInput.getStringInput();
        System.out.println("Username: ");
        String username = UserInput.getStringInput();
        System.out.println("Password: (Type \"1\" to generate a password)");
        String password = UserInput.getStringInput();
        if (password.equals("1")) {
            System.out.println("Length of password?");
            password = passwordToolsFactory.createPasswordGenerator().generate(UserInput.getIntInput(256));
        }
        System.out.println(passwordToolsFactory.createPasswordAnalyzer().analyze(password));
        System.out.println("Url: ");
        String url = UserInput.getStringInput();
        Password pass = new Password(name, username, password, url);
        passwordList.addPassword(pass);
        new MainMenu("Main Menu", passwordList, passwordToolsFactory).startMenu();
    }
}
class ExitItem extends MenuItem {
    public ExitItem(String name) {
        super(name);
    }

    @Override
    public void execute() {
    }
}
class GeneratePasswordWithLengthItem extends MenuItemWithPasswordListAndPasswordToolsFactory {
    public GeneratePasswordWithLengthItem(String name, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name, passwordList, passwordToolsFactory);
    }
    @Override
    public void execute() {
        System.out.println("Length of password?");
        System.out.println(passwordToolsFactory.createPasswordGenerator().generate(UserInput.getIntInput(256)));
        new PasswordToolsMenu("Password Tools Menu", passwordList, passwordToolsFactory).startMenu();
    }
}
class DeletePasswordItem extends MenuItemWithPasswordListAndPasswordToolsFactory {
    private final Password password;

    public DeletePasswordItem(String name, Password password, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name, passwordList, passwordToolsFactory);
        this.password = password;
    }

    @Override
    public void execute() {
        passwordList.removePassword(password);
        new PasswordsViewMenu("Passwords View Menu", passwordList, passwordToolsFactory).startMenu();
    }
}
class AnalyzePasswordItem extends MenuItemWithPasswordListAndPasswordToolsFactory {
    String password;
    public AnalyzePasswordItem(String name, String password, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name, passwordList, passwordToolsFactory);
        this.password = password;
    }
    public AnalyzePasswordItem(String name, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name, passwordList, passwordToolsFactory);
    }
    @Override
    public void execute() {
        if (password == null) {
            System.out.println("Password to analyze:");
            this.password = UserInput.getStringInput();
        }
        System.out.println(passwordToolsFactory.createPasswordAnalyzer().analyze(password));
        new MainMenu("Main Menu", passwordList, passwordToolsFactory).startMenu();
    }
}
class PasswordItem extends MenuWithPasswordListAndPasswordToolsFactory {
    Password password;
    PasswordItem(String name, Password password, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name, passwordList, passwordToolsFactory);
        this.password = password;
    }

    @Override
    public void printMenuName() {

    }

    @Override
    public void execute() {
        new PassInformationMenu("Password View Menu", password, passwordList, passwordToolsFactory).startMenu();
    }
}