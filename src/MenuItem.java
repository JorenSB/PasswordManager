import java.util.ArrayList;
import java.util.Comparator;

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
