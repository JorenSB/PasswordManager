import java.sql.SQLOutput;

abstract class MenuItem implements MenuAble{
    private final String name;
    public MenuItem(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
class PasswordsMenuItem extends MenuItem {
    public PasswordsMenuItem(String name) {
        super(name);
    }
    @Override
    public void Execute() {
        new PassMenu().StartMenu();
    }
}
class PasswordAddMenuItem extends MenuItem {
    public PasswordAddMenuItem(String name) {
        super(name);
    }
    @Override
    public void Execute() {
        String name;
        String username;
        String password;
        String url;
        System.out.println("Name: ");
        name = Connector.GetStringInput();
        System.out.println("Username: ");
        username = Connector.GetStringInput();
        System.out.println("Password: (Type \"1\" to generate a password)");
        password = Connector.GetStringInput();
        if (password.equals("1")) {
            System.out.println("Length of password?");
            password = PasswordGenerator.generatePassword(Connector.GetIntInput(256));
        }
        System.out.println("Url: ");
        url = Connector.GetStringInput();
        Password.addPass(new Password(name, username, password, url));
        new MainMenu().StartMenu();
    }
}
class ExitItem extends MenuItem {
    public ExitItem(String name) {
        super(name);
    }
    @Override
    public void Execute() {
        Connector.WritePasswords(Main.passwords);
    }
}
class MainMenuItem extends MenuItem {
    public MainMenuItem(String name) {
        super(name);
    }
    @Override
    public void Execute() {
        new MainMenu().StartMenu();
    }
}
class GeneratePasswordWithLengthItem extends MenuItem {
    public GeneratePasswordWithLengthItem(String name) {
        super(name);
    }
    @Override
    public void Execute() {
        System.out.println("Length of password?");
        System.out.println(PasswordGenerator.generatePassword(Connector.GetIntInput(256)));
        new MainMenu().StartMenu();
    }
}
class DeletePasswordItem extends MenuItem {
    private final Password password;
    public DeletePasswordItem(String name, Password password) {
        super(name);
        this.password = password;
    }
    @Override
    public void Execute() {
        password.removePass();
        new PassMenu().StartMenu();
    }
}
