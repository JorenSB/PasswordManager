import java.util.Random;
public class PasswordGenerator {
    public static String generatePassword(int maxLength) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+";
        Random random = new Random();
        StringBuilder password = new StringBuilder(maxLength);
        for (int i = 0; i < maxLength; i++) {
            int index = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }
        return password.toString();
    }
}
