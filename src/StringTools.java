public class StringTools {
    StringTools() {}
    protected int countCaps(String pass) {
        int caps = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isUpperCase(pass.charAt(i))) {
                caps++;
            }
        }
        return caps;
    }
    protected int countNums(String pass) {
        int nums = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i))) {
                nums++;
            }
        }
        return nums;
    }
    protected int countNonLetterChars(String pass) {
        int nonLetterChars = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (!Character.isLetter(pass.charAt(i))) {
                nonLetterChars++;
            }
        }
        return nonLetterChars;
    }
    protected int countSpecialChars(String pass) {
        int specialChars = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (!Character.isLetterOrDigit(pass.charAt(i))) {
                specialChars++;
            }
        }
        return specialChars;
    }
}
