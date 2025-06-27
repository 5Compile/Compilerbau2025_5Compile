package End2EndTests.Feature;

import End2EndTests.ReflectionUtility;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class End2End_DataTypes {

    private ReflectionUtility util;

    @BeforeEach
    void setup() {
        try {
            util = new ReflectionUtility("src/test/testing_files/DataTypes.java", "DataTypes");
        } catch (Exception e) {
            throw new RuntimeException("Fehler beim Setup", e);
        }
    }

    @Test
    void testClassLoadsCorrectly() {
        assertDoesNotThrow(() -> {
            // Nur checken, ob Methoden geladen werden können
            System.out.println("Methoden: " + util.getMethodNames());
        });
    }

}
