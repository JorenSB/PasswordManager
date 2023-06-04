import java.util.ArrayList;

public class PasswordList {


    private static ArrayList<Password> passwords;
    public static void startArrayList() {
        if (FileIO.getPasswords() == null) {
            passwords = new ArrayList<>();
        }
        else {
            passwords = new ArrayList<>(FileIO.getPasswords());
        }
    }
    public static ArrayList<Password> getPasswords() {
        return passwords;
    }
    public static void setPasswords(ArrayList<Password> passwords) {
        PasswordList.passwords = passwords;
    }
    public static void addPassword(Password password) {
        passwords.add(password);
    }
    public static void removePassword(Password password) {
        passwords.remove(password);
    }
    public static void clearPasswords() {
        passwords.clear();
    }
}
