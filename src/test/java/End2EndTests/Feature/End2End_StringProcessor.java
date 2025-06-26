package End2EndTests.Feature;

import End2EndTests.ReflectionUtility;
import org.junit.jupiter.api.*;

public class End2End_StringProcessor {
    private ReflectionUtility util;

    @BeforeEach
    void init() throws Exception {
        util = new ReflectionUtility("src/test/testing_files/StringProcessor.java", "StringProcessor");
    }

    @Test
    void testStringMethods() throws Exception {
        assertEquals("HELLO", util.invokeMethod("toUpper", new Class[]{String.class}, "hello"));
        assertEquals("olleh", util.invokeMethod("reverse", new Class[]{String.class}, "hello"));
        assertEquals(5, util.invokeMethod("length", new Class[]{String.class}, "hello"));
    }

    @Test
    void testMethodInfo() throws Exception {
        assertEquals(3, util.getMethodCount());
        assertTrue(util.getMethodNames().contains("toUpper"));
        assertEquals("int", util.getMethodReturnType("length", String.class));
    }
}