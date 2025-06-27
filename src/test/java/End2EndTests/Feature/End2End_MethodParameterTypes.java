package End2EndTests.Feature;

import End2EndTests.ReflectionUtility;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class End2End_MethodParameterTypes {
    private ReflectionUtility util;

    @BeforeEach
    void setup() throws Exception {
        util = new ReflectionUtility("src/test/testing_files/MethodParameterTypes.java", "MethodParameterTypes");
    }

    @Test
    void testParamCounts() throws Exception {
        assertEquals(1, util.getMethodParameterCount("oneParam", int.class));
        assertEquals(2, util.getMethodParameterCount("twoParams", String.class, boolean.class));
        assertEquals(3, util.getMethodParameterCount("mixed", int.class, String.class, double.class));
    }

    @Test
    void testParamTypes() throws Exception {
        assertEquals("int", util.getMethodParameterTypes("oneParam", int.class).get(0));
        assertEquals("String", util.getMethodParameterTypes("twoParams", String.class, boolean.class).get(0));
        assertEquals("boolean", util.getMethodParameterTypes("twoParams", String.class, boolean.class).get(1));
    }
}