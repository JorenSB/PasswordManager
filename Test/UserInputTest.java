import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
class UserInputTest {
    @Test
    void ReadAndWritePasswordsToAndFromFile() {
        // Arrange
        PasswordList passwordList = new PasswordList(new FileWriter("Test\\test.txt"));
        passwordList.clearPasswords();
        // Act
        passwordList.addPassword(new Password("test", "", "", ""));
        passwordList.addPassword(new Password("test2", "", "", ""));
        // Assert
        assertEquals(2, passwordList.getPasswordsFromWriter().size());
    }
}