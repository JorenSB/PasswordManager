import java.sql.SQLOutput;

abstract class MenuItem implements MenuAble{
    private String name;
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
        PassMenu pmenu = new PassMenu();
        pmenu.StartMenu();
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
        Main.passwords.add(new Password(name, username, password, url));
        MainMenu mmenu = new MainMenu();
        mmenu.StartMenu();
    }
}
class ExitItem extends MenuItem {
    public ExitItem(String name) {
        super(name);
    }
    @Override
    public void Execute() {
        Connector.WritePasswords(Main.passwords);
        System.exit(0);
    }
}
class MainMenuItem extends MenuItem {
    public MainMenuItem(String name) {
        super(name);
    }
    @Override
    public void Execute() {
        MainMenu mmenu = new MainMenu();
        mmenu.StartMenu();
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
        MainMenu mmenu = new MainMenu();
        mmenu.StartMenu();
    }
}
class DeletePasswordItem extends MenuItem {
    private Password password;
    public DeletePasswordItem(String name, Password password) {
        super(name);
        this.password = password;
    }
    @Override
    public void Execute() {
        password.removePass();
        PassMenu pmenu = new PassMenu();
        pmenu.StartMenu();
    }
}
