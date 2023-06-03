abstract class MenuItem implements MenuAble {
    private final String name;
    public MenuItem(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    abstract public void execute();
    PasswordManagerFactory passwordManagerFactory = new SimplePasswordManagerFactory();
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
        PasswordManagerFactory passwordManagerFactory = new SimplePasswordManagerFactory();
        System.out.println("Name: ");
        String name = Connector.getStringInput();
        System.out.println("Username: ");
        String username = Connector.getStringInput();
        System.out.println("Password: (Type \"1\" to generate a password)");
        String password = Connector.getStringInput();
        if (password.equals("1")) {
            System.out.println("Length of password?");
            password = passwordManagerFactory.createPasswordGenerator().generate(Connector.getIntInput(256));
        }
        System.out.println(passwordManagerFactory.createPasswordAnalyzer().analyze(password));
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
        PasswordManagerFactory passwordManagerFactory = new SimplePasswordManagerFactory();
        System.out.println("Length of password?");
        System.out.println(passwordManagerFactory.createPasswordGenerator().generate(Connector.getIntInput(256)));
        new PassToolsMenu().startMenu();
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
class AnalyzePasswordItem extends MenuItem {
    String password;
    public AnalyzePasswordItem(String name, String password) {
        super(name);
        this.password = password;
    }
    public AnalyzePasswordItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        if (password == null) {
            System.out.println("Password to analyze:");
            this.password = Connector.getStringInput();
        }
        PasswordManagerFactory passwordManagerFactory = new SimplePasswordManagerFactory();
        System.out.println(passwordManagerFactory.createPasswordAnalyzer().analyze(password));
        new PassToolsMenu().startMenu();
    }
}
class PasswordToolsMenuItem extends MenuItem {
    public PasswordToolsMenuItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        new PassToolsMenu().startMenu();
    }
}
class EncryptPassItem extends MenuItem {
    public EncryptPassItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        System.out.println("Password to encrypt:");
        String password = Connector.getStringInput();
        System.out.println("Secret key to use for encryption:");
        String secretKey = Connector.getStringInput();
        System.out.println(passwordManagerFactory.createPasswordEncryptor().encrypt(password, secretKey));
        new PassToolsMenu().startMenu();
    }
}
class DecryptPassItem extends MenuItem {
    public DecryptPassItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        System.out.println("Password to decrypt:");
        String password = Connector.getStringInput();
        System.out.println("Secret key to use for decryption:");
        String secretKey = Connector.getStringInput();
        System.out.println(passwordManagerFactory.createPasswordEncryptor().decrypt(password, secretKey));
        new PassToolsMenu().startMenu();
    }
}