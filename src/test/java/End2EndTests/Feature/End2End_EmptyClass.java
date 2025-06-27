package End2EndTests.Feature;

import End2EndTests.ReflectionUtility;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class End2End_EmptyClass {

    @Test
    void testEmptyClass() throws Exception {
        // Der Pfad zur leeren Quellklasse
        String sourceFilePath = "src/test/resources/EmptyClass.java";
        String className = "EmptyClass";

        // ReflectionUtility nutzen, um die Klasse zu laden
        ReflectionUtility reflectionUtility = new ReflectionUtility(sourceFilePath, className);

        // Verifizieren: Es gibt keine Methoden, Konstruktoren oder Felder
        assertEquals(1, reflectionUtility.getConstructorCount(), "Eine leere Klasse sollte genau einen Standardkonstruktor haben.");
        assertTrue(reflectionUtility.getFieldNames().isEmpty(), "Es sollten keine Felder vorhanden sein.");
        assertTrue(reflectionUtility.getMethodNames().isEmpty(), "Es sollten keine Methoden vorhanden sein.");

        System.out.println("✅ Test für die leere Klasse erfolgreich!");
    }
}