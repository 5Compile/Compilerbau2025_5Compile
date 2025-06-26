package End2EndTests.Feature;

import End2EndTests.ReflectionUtility;
import org.junit.jupiter.api.*;

public class End2End_MathUtils {
    private ReflectionUtility util;

    @BeforeEach
    void setup() throws Exception {
        util = new ReflectionUtility("src/test/testing_files/MathUtils.java", "MathUtils");
    }

    @Test
    void testMethods() throws Exception {
        assertEquals(3, util.getMethodCount());
        assertTrue(util.getMethodNames().contains("square"));
        assertTrue(util.getMethodNames().contains("cube"));
        assertTrue(util.getMethodNames().contains("isEven"));
    }

    @Test
    void testFunctionality() throws Exception {
        assertEquals(25, util.invokeMethod("square", new Class[]{int.class}, 5));
        assertEquals(27, util.invokeMethod("cube", new Class[]{int.class}, 3));
        assertEquals(true, util.invokeMethod("isEven", new Class[]{int.class}, 4));
        assertEquals(false, util.invokeMethod("isEven", new Class[]{int.class}, 5));
    }
}