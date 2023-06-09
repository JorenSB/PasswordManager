abstract class MenuItem implements MenuAble {
    private final String NAME;
    public MenuItem(String NAME) {
        this.NAME = NAME;
    }
    public String getName() {
        return NAME;
    }
    abstract public void execute();
}

abstract class MenuItemWithPasswordListAndPasswordToolsFactory extends MenuItem {
    protected final PasswordToolsFactory PASSWORD_TOOLS_FACTORY;
    protected final PasswordList PASSWORD_LIST;
    public MenuItemWithPasswordListAndPasswordToolsFactory(String name, PasswordList passwordList, PasswordToolsFactory PASSWORD_TOOLS_FACTORY) {
        super(name);
        this.PASSWORD_LIST = passwordList;
        this.PASSWORD_TOOLS_FACTORY = PASSWORD_TOOLS_FACTORY;
    }
}

class MainMenuItem extends MenuItemWithPasswordListAndPasswordToolsFactory {

    MainMenuItem(String name, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name, passwordList, passwordToolsFactory);
    }

    @Override
    public void execute() {
        new MainMenu(getName(), PASSWORD_LIST, PASSWORD_TOOLS_FACTORY).execute();
    }
}

class AddPasswordItem extends MenuItemWithPasswordListAndPasswordToolsFactory {
    public AddPasswordItem(String name, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
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
            password = PASSWORD_TOOLS_FACTORY.createPasswordGenerator().generate(UserInput.getIntInput(256));
        }
        System.out.println(PASSWORD_TOOLS_FACTORY.createPasswordAnalyzer().analyze(password));
        System.out.println("Url: ");
        String url = UserInput.getStringInput();
        Password pass = new Password(name, username, password, url);
        PASSWORD_LIST.addPassword(pass);
        new MainMenu("Main Menu", PASSWORD_LIST, PASSWORD_TOOLS_FACTORY).execute();
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
        System.out.println(PASSWORD_TOOLS_FACTORY.createPasswordGenerator().generate(UserInput.getIntInput(256)));
        new PasswordToolsMenu("Password Tools Menu", PASSWORD_LIST, PASSWORD_TOOLS_FACTORY).execute();
    }
}

class DeletePasswordItem extends MenuItemWithPasswordListAndPasswordToolsFactory {
    private final Password PASSWORD;
    public DeletePasswordItem(String name, Password PASSWORD, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name, passwordList, passwordToolsFactory);
        this.PASSWORD = PASSWORD;
    }

    @Override
    public void execute() {
        PASSWORD_LIST.removePassword(PASSWORD);
        new PasswordsViewMenu("Passwords View Menu", PASSWORD_LIST, PASSWORD_TOOLS_FACTORY).execute();
    }
}

class AnalyzePasswordItem extends MenuItemWithPasswordListAndPasswordToolsFactory {
    private String password;
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
        System.out.println(PASSWORD_TOOLS_FACTORY.createPasswordAnalyzer().analyze(password));
        new MainMenu("Main Menu", PASSWORD_LIST, PASSWORD_TOOLS_FACTORY).execute();
    }
}

class PasswordItem extends MenuItemWithPasswordListAndPasswordToolsFactory {
    private final Password PASSWORD;
    PasswordItem(String name, Password PASSWORD, PasswordList passwordList, PasswordToolsFactory passwordToolsFactory) {
        super(name, passwordList, passwordToolsFactory);
        this.PASSWORD = PASSWORD;
    }

    @Override
    public void execute() {
        new PasswordInformationMenu("Password View Menu", PASSWORD, PASSWORD_LIST, PASSWORD_TOOLS_FACTORY).execute();
    }
}