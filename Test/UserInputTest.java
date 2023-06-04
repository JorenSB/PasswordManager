import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
class UserInputTest {
    @Test
    void ReadAndWritePasswordsToAndFromFile() {
        // Arrange
        PasswordList.initialize("Test\\test.txt");
        PasswordList.clearPasswords();
        PasswordList.addPassword(new Password("test", "", "", ""));
        PasswordList.addPassword(new Password("test2", "", "", ""));
        FileIO fileIO = new FileIO("Test\\test.txt");
        // Act
        fileIO.savePasswords(PasswordList.getPasswords());
        PasswordList.setPasswords(new ArrayList<>(fileIO.getPasswords()));
        // Assert
        assertEquals(2, PasswordList.getPasswords().size());
    }
}