import java.util.Random;

interface PasswordToolsFactory {
    PasswordGenerator createPasswordGenerator();
    PasswordAnalyzer createPasswordAnalyzer();
}

class AdvancedPasswordToolsFactory implements PasswordToolsFactory {
    @Override
    public PasswordGenerator createPasswordGenerator() {
        return new AdvancedPasswordGenerator();
    }

    @Override
    public PasswordAnalyzer createPasswordAnalyzer() {
        return new AdvancedPasswordAnalyzer();
    }
}

class SimplePasswordToolsFactory implements PasswordToolsFactory {
    @Override
    public PasswordGenerator createPasswordGenerator() {
        return new SimplePasswordGenerator();
    }

    @Override
    public PasswordAnalyzer createPasswordAnalyzer() {
        return new SimplePasswordAnalyzer();
    }
}

interface PasswordGenerator {
    String generate(int length);
}

class SimplePasswordGenerator implements PasswordGenerator {
    private static final String ALLOWED_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+";
    private static final Random RANDOM = new Random();
    @Override
    public String generate(int length) {
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(ALLOWED_CHARS.length());
            password.append(ALLOWED_CHARS.charAt(index));
        }
        return password.toString();
    }
}

class AdvancedPasswordGenerator implements PasswordGenerator {
    private static final String ALLOWED_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+";
    private static final Random RANDOM = new Random();
    @Override
    public String generate(int length) {
        StringBuilder password = new StringBuilder();
        boolean loop = length >= 3;
        while (loop) {
            password = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                int index = RANDOM.nextInt(ALLOWED_CHARS.length());
                password.append(ALLOWED_CHARS.charAt(index));
            }
            if (countCaps(password.toString()) >= 1 && countNums(password.toString()) >= 1) {
                return password.toString();
            }
        }
        return password.toString();
    }
    private int countCaps(String pass) {
        int caps = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isUpperCase(pass.charAt(i))) {
                caps++;
            }
        }
        return caps;
    }
    private int countNums(String pass) {
        int nums = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i))) {
                nums++;
            }
        }
        return nums;
    }
}

interface PasswordAnalyzer {
    String analyze(String password);
}
class SimplePasswordAnalyzer implements PasswordAnalyzer {
    private static final int AMOUNT_OF_CAPS_FOR_GOOD = 3;
    private static final int AMOUNT_OF_CAPS_FOR_OKAY = 1;
    private static final int AMOUNT_OF_NUMS_AND_SPECIAL_CHARS_FOR_GOOD = 3;
    private static final int AMOUNT_OF_NUMS_AND_SPECIAL_CHARS_FOR_OKAY = 1;
    private static final int AMOUNT_OF_CHARS_FOR_GOOD = 15;
    private static final int AMOUNT_OF_CHARS_FOR_OKAY = 8;
    @Override
    public String analyze(String password) {
        if (countCaps(password) >= AMOUNT_OF_CAPS_FOR_GOOD && countNonLetterChars(password) >= AMOUNT_OF_NUMS_AND_SPECIAL_CHARS_FOR_GOOD && password.length() >= AMOUNT_OF_CHARS_FOR_GOOD) {
            return "Your password is good :)";
        } else if (countCaps(password) >= AMOUNT_OF_CAPS_FOR_OKAY && countNonLetterChars(password) >= AMOUNT_OF_NUMS_AND_SPECIAL_CHARS_FOR_OKAY && password.length() >= AMOUNT_OF_CHARS_FOR_OKAY) {
            return "Your password is okay.";
        } else {
            return "Your password is weak :(";
        }
    }
    private int countCaps(String pass) {
        int caps = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isUpperCase(pass.charAt(i))) {
                caps++;
            }
        }
        return caps;
    }
    private int countNonLetterChars(String pass) {
        int nonLetterChars = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (!Character.isLetter(pass.charAt(i))) {
                nonLetterChars++;
            }
        }
        return nonLetterChars;
    }
}

class AdvancedPasswordAnalyzer implements PasswordAnalyzer {
    private static final int AMOUNT_OF_CAPS_FOR_GOOD = 3;
    private static final int AMOUNT_OF_CAPS_FOR_OKAY = 1;
    private static final int AMOUNT_OF_NUMS_FOR_GOOD = 3;
    private static final int AMOUNT_OF_NUMS_FOR_OKAY = 1;
    private static final int AMOUNT_OF_SPECIAL_CHARS_FOR_GOOD = 3;
    private static final int AMOUNT_OF_SPECIAL_CHARS_FOR_OKAY = 1;
    private static final int AMOUNT_OF_CHARS_FOR_GOOD = 15;
    private static final int AMOUNT_OF_CHARS_FOR_OKAY = 8;
    @Override
    public String analyze(String password) {
        if (countCaps(password) >= AMOUNT_OF_CAPS_FOR_GOOD && (countNums(password) >= AMOUNT_OF_NUMS_FOR_GOOD || countSpecialChars(password) >= AMOUNT_OF_SPECIAL_CHARS_FOR_GOOD) && password.length() >= AMOUNT_OF_CHARS_FOR_GOOD) {
            return "Your password is good :)";
        } else if (countCaps(password) >= AMOUNT_OF_CAPS_FOR_OKAY && (countNums(password) >= AMOUNT_OF_NUMS_FOR_OKAY || countSpecialChars(password) >= AMOUNT_OF_SPECIAL_CHARS_FOR_OKAY) && password.length() >= AMOUNT_OF_CHARS_FOR_OKAY) {
            return "Your password is okay.";
        } else {
            return "Your password is weak :(";
        }
    }
    private int countCaps(String pass) {
        int caps = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isUpperCase(pass.charAt(i))) {
                caps++;
            }
        }
        return caps;
    }
    private int countNums(String pass) {
        int nums = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i))) {
                nums++;
            }
        }
        return nums;
    }
    private int countSpecialChars(String pass) {
        int specialChars = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (!Character.isLetterOrDigit(pass.charAt(i))) {
                specialChars++;
            }
        }
        return specialChars;
    }
}