package End2EndTests.Feature;

import End2EndTests.ReflectionUtility;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class End2End_SimpleClass {

    private ReflectionUtility util;

    @BeforeEach
    void setup() {
        try {
            util = new ReflectionUtility("src/test/testing_files/ClassDecl.java", "ClassDecl");
        } catch (Exception e) {
            throw new RuntimeException("Fehler beim Setup", e);
        }
    }

    @Test
    void testConstructorAvailableAndCorrect() {
        // Eine Klasse ohne Konstruktor hat automatisch einen parameterlosen Default-Konstruktor
        assertEquals(1, util.getConstructorCount());
        assertEquals("ClassDecl", util.getConstructorNames().get(0));
        assertEquals(0, util.getConstructorParameterCount(0));
    }

    @Test
    void testFieldsExist() {
        // Es gibt keine Felder in der Klasse
        assertEquals(0, util.getFieldCount());
    }

    @Test
    void testFunctionality() {
        try {
            Object instance = util.invokeConstructor(new Class[]{});
            assertNotNull(instance);
        } catch (Exception e) {
            fail("Fehler bei der Instanziierung.", e);
        }
    }
}
