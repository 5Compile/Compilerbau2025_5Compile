package End2EndTests.Feature;

import End2EndTests.ReflectionUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class End2End_ComplexExample {

    private ReflectionUtility util;

    @BeforeEach
    public void setUp() {
        try {
            util = new ReflectionUtility("src/test/testing_files/ComplexExample.java", "ComplexExample");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testConstructorCount() {
        Assertions.assertEquals(1, util.getConstructorCount());
    }

    @Test
    public void testFields() {
        Assertions.assertEquals(3, util.getFieldCount());
        Assertions.assertTrue(util.getFieldNames().contains("counter"));
        Assertions.assertTrue(util.getFieldNames().contains("active"));
        Assertions.assertTrue(util.getFieldNames().contains("name"));
    }

    @Test
    public void testFieldTypes() {
        Assertions.assertTrue(util.getFieldTypes().contains("int"));
        Assertions.assertTrue(util.getFieldTypes().contains("boolean"));
        Assertions.assertTrue(util.getFieldTypes().contains("String"));
    }

    @Test
    public void testMethodNames() {
        Assertions.assertTrue(util.getMethodNames().contains("getCounter"));
        Assertions.assertTrue(util.getMethodNames().contains("incrementCounter"));
        Assertions.assertTrue(util.getMethodNames().contains("isActive"));
        Assertions.assertTrue(util.getMethodNames().contains("deactivate"));
        Assertions.assertTrue(util.getMethodNames().contains("getName"));
        Assertions.assertTrue(util.getMethodNames().contains("updateName"));
        Assertions.assertTrue(util.getMethodNames().contains("calculateArea"));
        Assertions.assertTrue(util.getMethodNames().contains("summarize"));
    }

    @Test
    public void testReturnTypes() throws Exception {
        Assertions.assertEquals("int", util.getMethodReturnType("getCounter"));
        Assertions.assertEquals("void", util.getMethodReturnType("incrementCounter"));
        Assertions.assertEquals("boolean", util.getMethodReturnType("isActive"));
        Assertions.assertEquals("void", util.getMethodReturnType("deactivate"));
        Assertions.assertEquals("String", util.getMethodReturnType("getName"));
        Assertions.assertEquals("void", util.getMethodReturnType("updateName", new Class<?>[]{String.class}));
        Assertions.assertEquals("double", util.getMethodReturnType("calculateArea", new Class<?>[]{double.class, double.class}));
        Assertions.assertEquals("String", util.getMethodReturnType("summarize"));
    }

    @Test
    public void testParameterCounts() throws Exception {
        Assertions.assertEquals(0, util.getMethodParameterCount("getCounter"));
        Assertions.assertEquals(0, util.getMethodParameterCount("incrementCounter"));
        Assertions.assertEquals(0, util.getMethodParameterCount("isActive"));
        Assertions.assertEquals(0, util.getMethodParameterCount("deactivate"));
        Assertions.assertEquals(0, util.getMethodParameterCount("getName"));
        Assertions.assertEquals(1, util.getMethodParameterCount("updateName", new Class<?>[]{String.class}));
        Assertions.assertEquals(2, util.getMethodParameterCount("calculateArea", new Class<?>[]{double.class, double.class}));
        Assertions.assertEquals(0, util.getMethodParameterCount("summarize"));
    }

    @Test
    public void testInvokeSummarize() throws Exception {
        Object result = util.invokeMethod("summarize", new Class<?>[]{});
        Assertions.assertTrue(result.toString().contains("Compiler"));
    }

    @Test
    public void testInvokeUpdateName() throws Exception {
        util.invokeMethod("updateName", new Class<?>[]{String.class}, "Bytecode");
        Object result = util.invokeMethod("getName", new Class<?>[]{});
        Assertions.assertEquals("Bytecode", result);
    }

    @Test
    public void testInvokeCalculateArea() throws Exception {
        Object result = util.invokeMethod("calculateArea", new Class<?>[]{double.class, double.class}, 3.0, 4.0);
        Assertions.assertEquals(12.0, (Double) result);
    }
}
