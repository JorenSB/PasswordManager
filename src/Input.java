import java.util.Scanner;

class Input {
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
}