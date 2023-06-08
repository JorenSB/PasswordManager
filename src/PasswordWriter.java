import java.io.File;
import java.util.ArrayList;

public interface PasswordWriter {
    void savePasswords(ArrayList<Password> passwords);
    ArrayList<Password> getPasswords();
}
abstract class PasswordWriterExtension implements PasswordWriter {
    protected final File filename;
    public PasswordWriterExtension(String filename) {
        this.filename = new File(filename);
    }
}