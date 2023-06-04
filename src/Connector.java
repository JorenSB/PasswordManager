import java.util.ArrayList;
import java.util.Scanner;
class Connector {
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
}