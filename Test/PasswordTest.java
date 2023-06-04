import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class PasswordTest {
    @Test
    void addPass() {
        // Arrange
        PasswordList.initialize("Test\\test.txt");
        PasswordList.clearPasswords();
        Password p = new Password("Test", "", "", "");
        // Act
        PasswordList.addPassword(p);
        // Assert
        assertEquals(1, PasswordList.getPasswords().size());
    }
    @Test
    void removePass() {
        // Arrange
        PasswordList.initialize("Test\\test.txt");
        PasswordList.clearPasswords();
        Password p = new Password("Test", "", "", "");
        PasswordList.addPassword(p);
        // Act
        PasswordList.removePassword(p);
        // Assert
        assertEquals(0, PasswordList.getPasswords().size());
    }
}