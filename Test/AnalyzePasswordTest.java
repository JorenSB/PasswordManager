import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnalyzePasswordTest {
    //Modified Condition Decision Coverage Tests (MCDC)
    @Test
    public void checkPassIsGoodBecauseAllConditionsAreMet() {
        // Arrange
        String pass = "ABCdefghijkl123";
        String expected = "Uw wachtwoord is goed :)";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkPassISBadBecauseCapsConditionIsNotMet() {
        // Arrange
        String pass = "abcdefghijkl123";
        String expected = "Uw wachtwoord is slecht :(";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkPassIsBadBecauseSpecialCharsConditionIsNotMet() {
        // Arrange
        String pass = "ABCdefghijklmno";
        String expected = "Uw wachtwoord is slecht :(";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkPassIsBadBecauseLengthConditionIsNotMet() {
        // Arrange
        String pass = "ABC123";
        String expected = "Uw wachtwoord is slecht :(";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    // Equivalentieklassen en Randwaarden Tests
    @Test
    public void checkPassWith4Caps4SpecialAndLength16() {
        // Arrange
        String pass = "ABCDefghijkl1234";
        String expected = "Uw wachtwoord is goed :)";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkPassWith3Caps3SpecialAndLength15() {
        // Arrange
        String pass = "ABCdefghijkl123";
        String expected = "Uw wachtwoord is goed :)";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkPassWith2Caps2SpecialAndLength14() {
        // Arrange
        String pass = "ABcdefghijkl12";
        String expected = "Uw wachtwoord is voldoende.";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkPassWith2Caps2SpecialAndLength9() {
        // Arrange
        String pass = "ABcdefgh1";
        String expected = "Uw wachtwoord is voldoende.";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkPassWith1Caps1SpecialAndLength8() {
        // Arrange
        String pass = "Abcdefg1";
        String expected = "Uw wachtwoord is voldoende.";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkPassWith0Caps0SpecialAndLength7() {
        // Arrange
        String pass = "abcdefg";
        String expected = "Uw wachtwoord is slecht :(";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkPassWith0Caps0SpecialAndLength1() {
        // Arrange
        String pass = "a";
        String expected = "Uw wachtwoord is slecht :(";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    // Pairwise Testing (PT)
    @Test
    public void checkPassWith0Caps0Nums0SpecialAndLength1() {
        // Arrange
        String pass = "a";
        String expected = "Uw wachtwoord is slecht :(";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkPassWith0Caps1Nums1SpecialAndLength8() {
        // Arrange
        String pass = "abcdef1!";
        String expected = "Uw wachtwoord is slecht :(";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkPassWith0Caps3Nums3SpecialAndLength15() {
        // Arrange
        String pass = "abcdefghi123!@#";
        String expected = "Uw wachtwoord is slecht :(";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkPassWith1Caps1Nums3SpecialAndLength7() {
        // Arrange
        String pass = "Abc1!@#";
        String expected = "Uw wachtwoord is slecht :(";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkPassWith1Caps3Nums0SpecialAndLength8() {
        // Arrange
        String pass = "Abcde123";
        String expected = "Uw wachtwoord is voldoende.";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkPassWith1Caps0Nums1SpecialAndLength15() {
        // Arrange
        String pass = "Abcdefghijklmn!";
        String expected = "Uw wachtwoord is voldoende.";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkPassWith3Caps3Nums1SpecialAndLength7() {
        // Arrange
        String pass = "ABC123!";
        String expected = "Uw wachtwoord is slecht :(";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkPassWith3Caps0Nums3SpecialAndLength8() {
        // Arrange
        String pass = "ABCde!@#";
        String expected = "Uw wachtwoord is voldoende.";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkPassWith3Caps1Nums0SpecialAndLength15() {
        // Arrange
        String pass = "ABCdefghijklmn1";
        String expected = "Uw wachtwoord is voldoende.";
        // Act
        String actual = new AnalyzePassword().checkPass(pass);
        // Assert
        Assertions.assertEquals(expected, actual);
    }
}