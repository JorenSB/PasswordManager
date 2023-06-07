public class
Main {
    public static void main(String[] args) {
        PasswordList passwordList = new PasswordList(new FileWriter("data.txt"));
        PasswordToolsFactory passwordToolsFactory = new SimplePasswordToolsFactory();
        new MainMenu("Main Menu", passwordList, passwordToolsFactory).startMenu();
    }
}