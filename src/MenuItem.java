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
class PasswordsMenuItem extends MenuItem {
    public PasswordsMenuItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        new PassMenu().startMenu();
    }
}
class PasswordAddMenuItem extends MenuItem {
    public PasswordAddMenuItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        System.out.println("Name: ");
        String name = Connector.getStringInput();
        System.out.println("Username: ");
        String username = Connector.getStringInput();
        System.out.println("Password: (Type \"1\" to generate a password)");
        String password = Connector.getStringInput();
        if (password.equals("1")) {
            System.out.println("Length of password?");
            password = PasswordFactory.passwordFactory(Connector.getIntInput(256), false);
        }
        System.out.println(new AnalyzePassword().checkPass(password));
        System.out.println("Url: ");
        String url = Connector.getStringInput();
        Password pass = new Password(name, username, password, url);
        pass.addPass();
        new MainMenu().startMenu();
    }
}
class ExitItem extends MenuItem {
    public ExitItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        Connector.writePasswords(Connector.passwords);
    }
}
class MainMenuItem extends MenuItem {
    public MainMenuItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        new MainMenu().startMenu();
    }
}
class GeneratePasswordWithLengthItem extends MenuItem {
    public GeneratePasswordWithLengthItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        System.out.println("Length of password?");
        System.out.println(PasswordFactory.passwordFactory(Connector.getIntInput(256), false));
        new MainMenu().startMenu();
    }
}
class DeletePasswordItem extends MenuItem {
    private final Password password;
    public DeletePasswordItem(String name, Password password) {
        super(name);
        this.password = password;
    }
    @Override
    public void execute() {
        password.removePass();
        new PassMenu().startMenu();
    }
}
class AnalyzePasswordItem extends MenuItem{
    Password pass;
    public AnalyzePasswordItem(String name, Password pass) {
        super(name);
        this.pass = pass;
    }
    @Override
    public void execute() {
        System.out.println(new AnalyzePassword().checkPass(pass.getPassword()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
        new PassView().startMenu(pass);
    }
}
