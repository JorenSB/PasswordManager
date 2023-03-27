import java.util.ArrayList;
import java.util.Comparator;

abstract class MenuItem {
    private String name;
    public MenuItem(String name) {
        this.name = name;
    }
    public void Execute() {}
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
class PasswordItem extends MenuItem {
    private String passName;
    private String passUsername;
    private String passPass;
    private String passUrl;
    public PasswordItem(String name, String passUsername, String passPass, String passUrl) {
        super(name);
        this.passName = name;
        this.passUsername = passUsername;
        this.passPass = passPass;
        this.passUrl = passUrl;
    }
}
class PasswordAddMenuItem extends MenuItem {
    public PasswordAddMenuItem(String name) {
        super(name);
    }
    @Override
    public void Execute() {

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
