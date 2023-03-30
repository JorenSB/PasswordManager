import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
class ConnectorTest {
    @Test
    void ReadAndWritePasswordsToAndFromFile() {
        Connector.startArrayList();
        Connector.passwords.clear();
        Connector.passwords.add(new Password("test", "", "", ""));
        Connector.passwords.add(new Password("test2", "", "", ""));
        Connector.filename = new File("Test\\test.txt");
        Connector.writePasswords(Connector.passwords);
        Connector.passwords = new ArrayList<>(Connector.getPasswords());
        assertEquals(2, Connector.passwords.size());
    }
}