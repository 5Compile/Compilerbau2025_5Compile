package End2EndTests.Feature;

import End2EndTests.ReflectionUtility;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class End2End_Method {

    private ReflectionUtility util;

    @BeforeEach
    void setup() {
        try {
            util = new ReflectionUtility("src/test/testing_files/Method.java", "Method");
        } catch (Exception e) {
            throw new RuntimeException("Fehler beim Setup", e);
        }
    }

    @Test
    void testMethodCountAndNames() {
        assertEquals(1, util.getMethodCount());
        assertTrue(util.getMethodNames().contains("method"));
    }

    @Test
    void testMethodExecution() {
        try {
            Object instance = util.invokeConstructor(new Class[]{}, null);
            util.invokeMethod("method", new Class[]{}, instance);
            // Beim erfolgreichen Aufruf gibt es keinen Fehler.
            // Da die Methode "void" ist, wird nur getestet, dass sie aufgerufen werden kann.
        } catch (Exception e) {
            fail("Fehler beim Ausführen der Methode 'method'.", e);
        }
    }
}