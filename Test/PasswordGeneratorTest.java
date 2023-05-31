import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PasswordGeneratorTest {
    @Test
    void GeneratePassLength10Test() {
        // Arrange
        String pass = "";
        // Act
        pass = PasswordFactory.passwordFactory(10, false);
        // Assert
        assertEquals(10, pass.length());
    }
}