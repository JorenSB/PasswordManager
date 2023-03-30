import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
class Connector {
    public static ArrayList<Password> passwords;
    public static void startArrayList() {
        if (Connector.getPasswords() == null) {
            passwords = new ArrayList<>();
        }
        else {
            passwords = new ArrayList<>(Connector.getPasswords());
        }
    }
    public static int getIntInput(int max) {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        boolean validInput = false;
        while (!validInput) {
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                if (input > 0 && input <= max) {
                    validInput = true;
                }
                else {
                    sc.nextLine();
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            } else {
                sc.nextLine();
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return input;
    }
    public static String getStringInput() {
        Scanner sc = new Scanner(System.in);
        String input = "";
        boolean validInput = false;
        while (!validInput) {
            input = sc.nextLine();
            if (!input.isEmpty()) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid string.");
            }
        }
        return input;
    }
    static File filename = new File("data.txt");
    public static void writePasswords(ArrayList<Password> passwords) {
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
    public static ArrayList<Password> getPasswords() {
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