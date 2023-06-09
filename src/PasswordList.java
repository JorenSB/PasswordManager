import java.util.ArrayList;

public class PasswordList {
    private ArrayList<Password> passwords;
    private final PasswordWriter PASSWORD_WRITER;
    public PasswordList(PasswordWriter PASSWORD_WRITER) {
        this.PASSWORD_WRITER = PASSWORD_WRITER;
        this.passwords = PASSWORD_WRITER.getPasswords();
    }

    public ArrayList<Password> getPasswords() {
        return passwords;
    }

    public void setPasswords(ArrayList<Password> passwords) {
        this.passwords = passwords;
        savePasswords();
    }

    public void addPassword(Password password) {
        passwords.add(password);
        savePasswords();
    }

    public void removePassword(Password password) {
        passwords.remove(password);
        savePasswords();
    }

    public void clearPasswords() {
        passwords.clear();
        savePasswords();
    }

    private void savePasswords() {
        PASSWORD_WRITER.savePasswords(passwords);
    }

    public ArrayList<Password> getPasswordsFromWriter() {
        passwords = PASSWORD_WRITER.getPasswords();
        return passwords;
    }
}