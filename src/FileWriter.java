import java.io.*;
import java.util.ArrayList;

public class FileWriter extends PasswordWriterExtension {
    public FileWriter(String filename) {
        super(filename);
    }

    @Override
    public void savePasswords(ArrayList<Password> passwords) {
        try {
            FileOutputStream fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(passwords);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Password> getPasswords() {
        ArrayList<Password> passwords = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(FILENAME);
            if (fis.available() > 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                passwords = (ArrayList<Password>) ois.readObject();
                ois.close();
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passwords;
    }
}