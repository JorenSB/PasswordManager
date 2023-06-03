import java.util.Random;
class GeneratorManager {
    private static final int amountOfGenerators = 2;
    public static int getAmountOfGenerators() {
        return amountOfGenerators;
    }
    public static String generatePassword(int length, boolean mustContainCapAndSpecialChar) {
        if (mustContainCapAndSpecialChar) {
            return PasswordGeneratorV2.generatePassword(length);
        }
        else {
            return PasswordGenerator.generatePassword(length);
        }
    }
}
class PasswordGenerator {
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
class PasswordGeneratorV2 {
    public static String generatePassword(int maxLength) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+";
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        boolean loop = maxLength >= 3;
        while (loop) {
            password = new StringBuilder(maxLength);
            for (int i = 0; i < maxLength; i++) {
                int index = random.nextInt(allowedChars.length());
                password.append(allowedChars.charAt(index));
            }
            if (containsCapital(password.toString()) && containsNum(password.toString())) {
                return password.toString();
            }
        }
        return password.toString();
    }
    public static boolean containsCapital(String string) {
        for (char c : string.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsNum(String string) {
        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}