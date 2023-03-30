import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class PasswordTest {
    @Test
    void addPass() {
        Connector.startArrayList();
        Connector.passwords.clear();
        Password p = new Password("Test", "", "", "");
        p.addPass();
        assertEquals(1, Connector.passwords.size());
    }
    @Test
    void removePass() {
        Connector.startArrayList();
        Connector.passwords.clear();
        Password p = new Password("Test", "", "", "");
        Connector.passwords.add(p);
        p.removePass();
        assertEquals(0, Connector.passwords.size());
    }
}