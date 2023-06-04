import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PasswordGeneratorTest {
    @Test
    void GeneratePassLength10Test() {
        // Arrange
        String pass = "";
        PasswordToolsFactory passwordToolsFactory = new SimplePasswordToolsFactory();
        // Act
        pass = passwordToolsFactory.createPasswordGenerator().generate(10);
        // Assert
        assertEquals(10, pass.length());
    }
}