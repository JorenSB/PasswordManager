import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonWriter extends PasswordWriterExtension {
    public JsonWriter(String filename) {
        super(filename);
    }
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void savePasswords(ArrayList<Password> passwords) {
        String json = gson.toJson(passwords);
         try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(json);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public ArrayList<Password> getPasswords() {
        ArrayList<Password> passwords = new ArrayList<>();
        Type founderListType = new TypeToken<ArrayList<Password>>(){}.getType();

        try {
            FileInputStream fis = new FileInputStream(filename);
            if (fis.available() > 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                passwords =  gson.fromJson(ois.readObject().toString(), founderListType);
                ois.close();
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passwords;
    }
    
}
