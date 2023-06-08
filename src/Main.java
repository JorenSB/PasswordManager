public class Main {
    static final PasswordList passwordList = new PasswordList(new FileWriter("data.txt"));
    static final PasswordToolsFactory passwordToolsFactory = new SimplePasswordToolsFactory();
    public static void main(String[] args) {
        new MainMenu("Main Menu", passwordList, passwordToolsFactory).execute();
    }
}