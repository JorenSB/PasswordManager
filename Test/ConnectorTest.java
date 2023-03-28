import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ConnectorTest {
    @Test
    void ReadAndWritePasswordsToAndFromFile() {
        Connector.StartArrayList();
        Connector.passwords.clear();
        Connector.passwords.add(new Password("test", "", "", ""));
        Connector.passwords.add(new Password("test2", "", "", ""));
        Connector.filename = new File("Test\\test.txt");
        Connector.WritePasswords(Connector.passwords);
        Connector.passwords = new ArrayList<>(Connector.GetPasswords());
        assertEquals(2, Connector.passwords.size());
    }
}