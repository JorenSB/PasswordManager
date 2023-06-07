import java.util.ArrayList;

public class PasswordList {
    private ArrayList<Password> passwords;
    private final PasswordWriter passwordWriter;
    public PasswordList(PasswordWriter passwordWriter) {
        this.passwordWriter = passwordWriter;
        this.passwords = passwordWriter.getPasswords();
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
        passwordWriter.savePasswords(passwords);
    }
    public ArrayList<Password> getPasswordsFromWriter() {
        passwords = passwordWriter.getPasswords();
        return passwords;
    }
}