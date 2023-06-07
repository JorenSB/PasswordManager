import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class PasswordTest {
    @Test
    void addPass() {
        // Arrange
        PasswordList passwordList = new PasswordList(new FileWriter("Test\\test.txt"));
        passwordList.clearPasswords();
        Password p = new Password("Test", "", "", "");
        // Act
        passwordList.addPassword(p);
        // Assert
        assertEquals(1, passwordList.getPasswords().size());
    }
    @Test
    void removePass() {
        // Arrange
        PasswordList passwordList = new PasswordList(new FileWriter("Test\\test.txt"));
        passwordList.clearPasswords();
        Password p = new Password("Test", "", "", "");
        passwordList.addPassword(p);
        // Act
        passwordList.removePassword(p);
        // Assert
        assertEquals(0, passwordList.getPasswords().size());
    }
}