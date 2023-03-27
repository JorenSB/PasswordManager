import java.util.ArrayList;
import java.util.Scanner;

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
        items.get(Input.GetIntInput(items.size())-1).Execute();
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
