import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {
    @Test
    void addPass() {
        Connector.StartArrayList();
        Main.passwords.clear();
        Password.addPass(new Password("Test", "test", "test123", "Test.com"));
        assertEquals(1, Main.passwords.size());
    }
    @Test
    void removePass() {
        Connector.StartArrayList();
        Main.passwords.clear();
        Password p = new Password("Test", "test", "test123", "Test.com");
        Main.passwords.add(p);
        p.removePass();
        assertEquals(0, Main.passwords.size());
    }
}