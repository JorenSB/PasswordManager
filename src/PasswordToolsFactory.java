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
abstract class PasswordGeneratorWithRandom implements PasswordGenerator {
    protected static final String ALLOWED_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+";
    protected static final Random RANDOM = new Random();
}

class SimplePasswordGenerator extends PasswordGeneratorWithRandom {

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

class AdvancedPasswordGenerator extends PasswordGeneratorWithRandom {
    @Override
    public String generate(int length) {
        StringTools stringTools = new StringTools();
        StringBuilder password = new StringBuilder();
        boolean loop = length >= 3;
        while (loop) {
            password = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                int index = RANDOM.nextInt(ALLOWED_CHARS.length());
                password.append(ALLOWED_CHARS.charAt(index));
            }
            if (stringTools.countCaps(password.toString()) >= 1 && stringTools.countNums(password.toString()) >= 1) {
                return password.toString();
            }
        }
        return password.toString();
    }
}

interface PasswordAnalyzer {
    String analyze(String password);
}
abstract class PasswordAnalyzerWithConstraints implements PasswordAnalyzer {
    protected static final int AMOUNT_OF_CAPS_FOR_GOOD = 3;
    protected static final int AMOUNT_OF_CAPS_FOR_OKAY = 1;
    protected static final int AMOUNT_OF_CHARS_FOR_GOOD = 15;
    protected static final int AMOUNT_OF_CHARS_FOR_OKAY = 8;
}
class   SimplePasswordAnalyzer extends PasswordAnalyzerWithConstraints {

    @Override
    public String analyze(String password) {
        final int AMOUNT_OF_NUMS_AND_SPECIAL_CHARS_FOR_GOOD = 3;
        final int AMOUNT_OF_NUMS_AND_SPECIAL_CHARS_FOR_OKAY = 1;
        StringTools stringTools = new StringTools();
        if (stringTools.countCaps(password) >= AMOUNT_OF_CAPS_FOR_GOOD && stringTools.countNonLetterChars(password) >= AMOUNT_OF_NUMS_AND_SPECIAL_CHARS_FOR_GOOD && password.length() >= AMOUNT_OF_CHARS_FOR_GOOD) {
            return "Your password is good :)";
        } else if (stringTools.countCaps(password) >= AMOUNT_OF_CAPS_FOR_OKAY && stringTools.countNonLetterChars(password) >= AMOUNT_OF_NUMS_AND_SPECIAL_CHARS_FOR_OKAY && password.length() >= AMOUNT_OF_CHARS_FOR_OKAY) {
            return "Your password is okay.";
        } else {
            return "Your password is weak :(";
        }
    }
}

class AdvancedPasswordAnalyzer extends PasswordAnalyzerWithConstraints {
    @Override
    public String analyze(String password) {
        final int AMOUNT_OF_NUMS_FOR_GOOD = 3;
        final int AMOUNT_OF_NUMS_FOR_OKAY = 1;
        final int AMOUNT_OF_SPECIAL_CHARS_FOR_GOOD = 3;
        final int AMOUNT_OF_SPECIAL_CHARS_FOR_OKAY = 1;
        StringTools stringTools = new StringTools();
        if (stringTools.countCaps(password) >= AMOUNT_OF_CAPS_FOR_GOOD && (stringTools.countNums(password) >= AMOUNT_OF_NUMS_FOR_GOOD || stringTools.countSpecialChars(password) >= AMOUNT_OF_SPECIAL_CHARS_FOR_GOOD) && password.length() >= AMOUNT_OF_CHARS_FOR_GOOD) {
            return "Your password is good :)";
        } else if (stringTools.countCaps(password) >= AMOUNT_OF_CAPS_FOR_OKAY && (stringTools.countNums(password) >= AMOUNT_OF_NUMS_FOR_OKAY || stringTools.countSpecialChars(password) >= AMOUNT_OF_SPECIAL_CHARS_FOR_OKAY) && password.length() >= AMOUNT_OF_CHARS_FOR_OKAY) {
            return "Your password is okay.";
        } else {
            return "Your password is weak :(";
        }
    }
}