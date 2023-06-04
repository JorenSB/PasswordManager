import java.util.ArrayList;

public class PasswordList {
    private static ArrayList<Password> passwords;
    private static PasswordRepository passwordRepository;

    public static void initialize(String filename) {
        passwordRepository = new FileIO(filename);
        passwords = passwordRepository.getPasswords();
        if (passwords == null) {
            passwords = new ArrayList<>();
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