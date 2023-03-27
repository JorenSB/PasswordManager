import java.io.*;
import java.util.ArrayList;

public class PasswordTools {
    private static final File filename = new File("data.txt");

    public static void WritePasswords(ArrayList<Password> passwords) {
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

    public static ArrayList<Password> GetPasswords() {
        ArrayList<Password> passwords = null;
            try {
                FileInputStream fis = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fis);
                passwords = (ArrayList<Password>) ois.readObject();
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();}
            return passwords;
    }
}
