import java.util.ArrayList;

public interface PasswordWriter {
    void savePasswords(ArrayList<Password> passwords);
    ArrayList<Password> getPasswords();
}
