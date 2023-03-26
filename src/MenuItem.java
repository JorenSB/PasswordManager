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
class PasswordsMenuItem extends MenuItem{
    public PasswordsMenuItem(String name) {
        super(name);
    }
    @Override
    public void Execute() {

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
        System.exit(0);
    }
}
class GenerateMenuItem extends MenuItem {
    public GenerateMenuItem(String name) {
        super(name);
    }
    @Override
    public void Execute() {
        GenerateMenu gmenu = new GenerateMenu();
        gmenu.StartMenu();
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
        System.out.println(PasswordGenerator.generatePassword(Input.GetIntInput(256)));
        GenerateMenu gmenu = new GenerateMenu();
        gmenu.StartMenu();
    }
}
