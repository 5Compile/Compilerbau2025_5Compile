package End2EndTests.Feature;

import End2EndTests.ReflectionUtility;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class End2End_ReturnTypes {
    private ReflectionUtility util;

    @BeforeEach
    void init() throws Exception {
        util = new ReflectionUtility("src/test/testing_files/ReturnTypes.java", "ReturnTypes");
    }

    @Test
    void testReturnTypes() throws Exception {
        assertEquals("int", util.getMethodReturnType("returnInt"));
        assertEquals("String", util.getMethodReturnType("returnString"));
        assertEquals("boolean", util.getMethodReturnType("returnBool"));
        assertEquals("double", util.getMethodReturnType("returnDouble"));
        assertEquals("void", util.getMethodReturnType("returnNothing"));
    }
}