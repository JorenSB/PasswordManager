import java.util.ArrayList;
import java.util.Comparator;

abstract class Menu {
    ArrayList<MenuItem> items;
    Menu() {
        items = new ArrayList<>();
    }
    public void PrintMenu() {
        int index = 1;
        for (MenuItem item : items) {
            System.out.printf("%d : %s\n", index, item.getName());
            index++;
        }
        items.get(Connector.GetIntInput(items.size())-1).Execute();
    }
}
class MainMenu extends Menu {
    public void StartMenu() {
        items.add(new PasswordsMenuItem("View passwords"));
        items.add(new PasswordAddMenuItem("Add a password"));
        items.add(new GeneratePasswordWithLengthItem("Generate password"));
        items.add(new ExitItem("Exit"));
        PrintMenu();
    }
}
class PassMenu extends Menu {
    public void StartMenu() {
        if (Main.passwords != null) {
            for (Password pass : Main.passwords) {
                items.add(new PasswordItem(pass.getName(), pass.getUsername(), pass.getPassword(), pass.getPassword()));
            }
        }
        items.add(new MainMenuItem("Main Menu"));
        items.add(new ExitItem("Exit"));
        PrintMenu();
//        System.out.println("Saved Passwords: ");
//        ArrayList<Password> passwords = new ArrayList<>(Connector.GetPasswords());
//        passwords.sort(Comparator.comparing(Password::getName));
//        int index = 1;
//        for (Password pw : passwords) {
//            System.out.printf("%d : %s\n", index, pw.getName());
//            index++;
//        }
//        System.out.println(index + " : Main Menu");
//        int input = Connector.GetIntInput(passwords.size()+1);
//        if (input > passwords.size()) {
//            MainMenu mmenu = new MainMenu();
//            mmenu.StartMenu();
//        }
//        else {
//            Password pw = passwords.get(input-1);
//            System.out.printf("Name: %s \nUsername: %s\nPassword: %s\nUrl: %s", pw.getName(), pw.getUsername(), pw.getPassword(), pw.getUrl());
//            PasswordsMenuItem pmenu = new PasswordsMenuItem("");
//            pmenu.Execute();
//        }
    }
}
