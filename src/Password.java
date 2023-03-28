import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;


public class Password implements MenuAble, Serializable {
    private String name;
    private String username;
    private String password;
    private String url;
    public Password(String name, String username, String password, String url) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.url = url;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void removePass() {
        Connector.passwords.removeIf(password -> password.equals(this));
    }
    public static void addPass(Password pass) {
        Connector.passwords.add(pass);
    }
    @Override
    public void Execute() {
        new PassView().StartMenu(this);
    }
}
