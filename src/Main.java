import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static ArrayList<Password> passwords;
    public static void main(String[] args) {
        if (Connector.GetPasswords() == null) { passwords = new ArrayList<>();}
        else { passwords = new ArrayList<>(Connector.GetPasswords());}
//        passwords.add(new Password("Google", "john.doe@example.com", "password123", "google.com"));
//        passwords.add(new Password("Github", "john.doe@example.com", "password123", "github.com"));
//        passwords.add(new Password("Haagse Hogeschool", "john.doe@example.com", "password123", "hhs.nl"));
//        passwords.add(new Password("Netflix","john.doe@example.com", "password123", "netflix.com"));
        Connector.WritePasswords(passwords);
        MainMenu mmenu = new MainMenu();
        mmenu.StartMenu();
    }
}