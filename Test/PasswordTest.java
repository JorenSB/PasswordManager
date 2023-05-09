import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class PasswordTest {
    @Test
    void addPass() {
        // Arrange
        Connector.startArrayList();
        Connector.passwords.clear();
        Password p = new Password("Test", "", "", "");
        // Act
        p.addPass();
        // Assert
        assertEquals(1, Connector.passwords.size());
    }
    @Test
    void removePass() {
        // Arrange
        Connector.startArrayList();
        Connector.passwords.clear();
        Password p = new Password("Test", "", "", "");
        Connector.passwords.add(p);
        // Act
        p.removePass();
        // Assert
        assertEquals(0, Connector.passwords.size());
    }
}