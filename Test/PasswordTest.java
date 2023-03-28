import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordTest {
    @Test
    void addPass() {
        Connector.StartArrayList();
        Connector.passwords.clear();
        Password.addPass(new Password("Test", "", "", ""));
        assertEquals(1, Connector.passwords.size());
    }
    @Test
    void removePass() {
        Connector.StartArrayList();
        Connector.passwords.clear();
        Password p = new Password("Test", "", "", "");
        Connector.passwords.add(p);
        p.removePass();
        assertEquals(0, Connector.passwords.size());
    }
}