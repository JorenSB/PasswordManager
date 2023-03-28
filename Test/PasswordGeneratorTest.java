import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PasswordGeneratorTest {
    @Test
    void GeneratePassLength10Test() {
        String pass = "";
        pass = PasswordGenerator.generatePassword(10);
        assertEquals(10, pass.length());
    }
}