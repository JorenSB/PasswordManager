import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ConnectorTest {
    @Test
    void ReadAndWritePasswordsToAndFromFile() {
        // Arrange
        PasswordList.startArrayList();
        PasswordList.clearPasswords();
        PasswordList.addPassword(new Password("test", "", "", ""));
        PasswordList.addPassword(new Password("test2", "", "", ""));
        FileIO.filename = new File("Test\\test.txt");
        // Act
        FileIO.writePasswords(PasswordList.getPasswords());
        PasswordList.setPasswords(new ArrayList<>(FileIO.getPasswords()));
        // Assert
        assertEquals(2, PasswordList.getPasswords().size());
    }
}