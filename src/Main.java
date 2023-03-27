import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MainMenu mmenu = new MainMenu();
        //mmenu.StartMenu();
        ArrayList<Password> passwords = new ArrayList<>();
        passwords.add(new Password("Test", "Pass", "gogle.com"));
        passwords.add(new Password("Test", "Pass", "go0gle.com"));
        passwords.add(new Password("Test", "Pass", "google.com"));
        passwords.add(new Password("Test", "Pass", "goigle.com"));
        //PasswordTools.testWrite();
        PasswordTools.WritePasswords(passwords);
        ArrayList<Password> test = new ArrayList<>(PasswordTools.GetPasswords());
        for (Password password : test) {
            System.out.println(password.getUsername());
        }
    }
}