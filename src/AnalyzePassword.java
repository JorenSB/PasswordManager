public class AnalyzePassword {
    public AnalyzePassword() {}
    public String checkPass(String pass) {
        int aantalCapsVoorGoed = 4;
        int aantalCapsVoorVoldoende = 1;
        int aantalSpecialCharsVoorGoed = 4;
        int aantalSpecialCharsVoorVoldoende = 1;
        int aantalNummersVoorGoed = 4;
        int aantalNummersVoorVoldoende = 1;
        int aantalCharsVoorGoed = 15;
        int aantalCharsVoorVoldoende = 8;
        if (countCaps(pass) >= aantalCapsVoorGoed && countNumbers(pass) >= aantalNummersVoorGoed &&
                countSpecialChars(pass) >= aantalSpecialCharsVoorGoed && checkLength(pass) >= aantalCharsVoorGoed) {
            return "Uw wachtwoord is goed :)";
        }
        else if (countCaps(pass) >= aantalCapsVoorVoldoende && countNumbers(pass) >= aantalNummersVoorVoldoende &&
                countSpecialChars(pass) >= aantalSpecialCharsVoorVoldoende && checkLength(pass) >= aantalCharsVoorVoldoende) {
            return "Uw wachtwoord is voldoende.";
        }
        else {
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
    public int checkLength(String pass) {
        return pass.length();
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
    public int countNumbers(String pass) {
        int numbers = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i))) {
                numbers++;
            }
        }
        return numbers;
    }
}
