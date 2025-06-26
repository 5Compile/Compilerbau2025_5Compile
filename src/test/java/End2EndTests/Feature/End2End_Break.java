package End2EndTests.Feature;

import End2EndTests.ReflectionUtility;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class End2End_Break {

    private ReflectionUtility util;

    @BeforeEach
    void setup() {
        try {
            util = new ReflectionUtility("src/test/testing_files/End2EndBreak.java", "Break");
        } catch (Exception e) {
            throw new RuntimeException("Fehler beim Setup", e);
        }
    }

    @Test
    void testConstructorAvailableAndCorrect() {
        assertEquals(1, util.getConstructorCount());
        assertEquals("Break", util.getConstructorNames().get(0));
        assertEquals(0, util.getConstructorParameterCount(0));
    }

    @Test
    void testConstructorWorks() {
        try {
            Object instance = util.invokeConstructor(new Class[]{}, null);
            assertEquals("Break", instance.getClass().getSimpleName());
        } catch (Exception e) {
            fail("Konstruktor sollte ohne Fehler durchlaufen.");
        }
    }

    @Test
    void testNoFieldsOrMethodsPresent() {
        assertEquals(0, util.getFieldCount());
        assertEquals(0, util.getMethodCount());
    }
}
