import java.io.*;
import java.util.ArrayList;

public class FileIO {
    static File filename = new File("data.txt");
    public void setFilename(String filename) {
        FileIO.filename = new File(filename);
    }
    public void writePasswords(ArrayList<Password> passwords) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(passwords);
            oos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Password> getPasswords() {
        ArrayList<Password> passwords = null;
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
