public class AnalyzePassword {
    public AnalyzePassword() {}
    public String checkPassAdvanced(String pass) {
        int amountOfCapsForGood = 3;
        int amountOfCapsForOkay = 1;
        int amountOfNumsForGood = 3;
        int amountOfNumsForOkay = 1;
        int amountOfSpecialCharsForGood = 3;
        int amountOfSpecialCharsForOkay = 1;
        int amountOfCharsForGood = 15;
        int amountOfCharsForOkay = 8;
        if (countCaps(pass) >= amountOfCapsForGood && countNums(pass) >= amountOfNumsForGood || countSpecialChars(pass) > amountOfSpecialCharsForGood && pass.length() >= amountOfCharsForGood) {
            return "Uw wachtwoord is goed :)";
        } else if (countCaps(pass) >= amountOfCapsForOkay && countNums(pass) >= amountOfNumsForOkay || countSpecialChars(pass) > amountOfSpecialCharsForOkay && pass.length() >= amountOfCharsForOkay) {
            return "Uw wachtwoord is voldoende.";
        } else {
            return "Uw wachtwoord is slecht :(";
        }
    }
    public String checkPass(String pass) {
        int amountOfCapsForGood = 3;
        int amountOfCapsForOkay = 1;
        int amountOfNumsAndSpecialCharsForGood = 3;
        int amountOfNumsAndSpecialCharsForOkay = 1;
        int amountOfCharsForGood = 15;
        int amountOfCharsForOkay = 8;
        if (countCaps(pass) >= amountOfCapsForGood && countNonLetterChars(pass) >= amountOfNumsAndSpecialCharsForGood && pass.length() >= amountOfCharsForGood) {
            return "Uw wachtwoord is goed :)";
        } else if (countCaps(pass) >= amountOfCapsForOkay && countNonLetterChars(pass) >= amountOfNumsAndSpecialCharsForOkay && pass.length() >= amountOfCharsForOkay) {
            return "Uw wachtwoord is voldoende.";
        } else {
            return "Uw wachtwoord is slecht :(";
        }
    }
    public int countCaps(String pass) {
        int caps = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isUpperCase(pass.charAt(i))) {
                caps++;
            }
        }
        return caps;
    }
    public int countNums(String pass) {
        int nums = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i))) {
                nums++;
            }
        }
        return nums;
    }
    public int countSpecialChars(String pass) {
        int specialChars = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (!Character.isLetterOrDigit(pass.charAt(i))) {
                specialChars++;
            }
        }
        return specialChars;
    }
    public int countNonLetterChars(String pass) {
        return countNums(pass) + countSpecialChars(pass);
    }
}
