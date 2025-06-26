package End2EndTests.Feature;

import End2EndTests.ReflectionUtility;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class End2End_MethodTestClass {
    private ReflectionUtility util;

    @BeforeEach
    void init() throws Exception {
        util = new ReflectionUtility("src/test/testing_files/MethodTestClass.java", "MethodTestClass");
    }

    @Test
    void testMethodCountAndNames() {
        assertEquals(5, util.getMethodCount());
        assertTrue(util.getMethodNames().contains("sum"));
        assertTrue(util.getMethodNames().contains("concat"));
        assertTrue(util.getMethodNames().contains("isPositive"));
        assertTrue(util.getMethodNames().contains("printMessage"));
        assertTrue(util.getMethodNames().contains("multiply"));
    }

    @Test
    void testMethodExecution() throws Exception {
        assertEquals(3, util.invokeMethod("sum", new Class[]{int.class, int.class}, 1, 2));
        assertEquals("ab", util.invokeMethod("concat", new Class[]{String.class, String.class}, "a", "b"));
        assertEquals(true, util.invokeMethod("isPositive", new Class[]{int.class}, 1));
        assertEquals(false, util.invokeMethod("isPositive", new Class[]{int.class}, -1));
        assertEquals(6.0, util.invokeMethod("multiply", new Class[]{double.class, double.class}, 2.0, 3.0));
    }
}