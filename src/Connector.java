import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Connector {
    public static int GetIntInput(int size) {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        boolean validInput = false;
        while (!validInput) {
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                if (input > 0 && input <= size) {
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