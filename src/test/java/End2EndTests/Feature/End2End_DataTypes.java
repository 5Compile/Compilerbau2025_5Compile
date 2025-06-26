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
    @Test
    void testDebugReflectionDump() {
        assertDoesNotThrow(() -> {
            Class<?> cls = util.getCompiledClass();

            System.out.println("🧠 Geladene Klasse: " + cls.getName());
            System.out.println("🔧 Konstruktoren: " + util.getConstructorNames());
            System.out.println("🧪 Methoden: " + util.getMethodNames());
            System.out.println("📦 Felder: " + util.getFieldNames());

            System.out.println("🛠️ Methoden im Detail:");
            for (var method : cls.getDeclaredMethods()) {
                System.out.println(" - " + method.getName() + " | Rückgabe: " + method.getReturnType().getSimpleName() + " | Parameter: " + Arrays.toString(method.getParameterTypes()));
            }
        });
    }






}
