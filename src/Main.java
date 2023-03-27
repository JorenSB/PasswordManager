import java.util.ArrayList;

public class Main {
    public static ArrayList<Password> passwords;
    public static void main(String[] args) {
        MainMenu mmenu = new MainMenu();
        passwords = Connector.GetPasswords();
        mmenu.StartMenu();

//        ArrayList<Password> passwords = new ArrayList<>(Connector.GetPasswords());
////        passwords.add(new Password("Google", "john.doe@example.com", "password123", "google.com"));
////        passwords.add(new Password("Github", "john.doe@example.com", "password123", "github.com"));
////        passwords.add(new Password("Haagse Hogeschool", "john.doe@example.com", "password123", "hhs.nl"));
////        passwords.add(new Password("Netflix","john.doe@example.com", "password123", "netflix.com"));
////        //PasswordTools.testWrite();
////        Connector.WritePasswords(passwords);
////        ArrayList<Password> test = new ArrayList<>(Connector.GetPasswords());
//        for (Password password : passwords) {
//            System.out.println(password.getName());
//        }
    }
}