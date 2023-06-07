import java.io.*;
import java.util.ArrayList;

public class FileWriter implements PasswordWriter {
    private final File filename;
    public FileWriter(String filename) {
        this.filename = new File(filename);
    }
    @Override
    public void savePasswords(ArrayList<Password> passwords) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
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
            FileInputStream fis = new FileInputStream(filename);
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