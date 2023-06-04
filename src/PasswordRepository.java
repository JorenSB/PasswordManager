import java.util.ArrayList;

public interface PasswordRepository {
    void savePasswords(ArrayList<Password> passwords);
    ArrayList<Password> getPasswords();
}
