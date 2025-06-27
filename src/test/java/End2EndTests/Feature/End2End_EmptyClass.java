package End2EndTests.Feature;

import End2EndTests.ReflectionUtility;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class End2End_EmptyClass {

    @Test
    void testEmptyClass() throws Exception {
        // Der Pfad zur leeren Quellklasse
        String sourceFilePath = "src/test/testing_Files/ClassDecl.java";
        String className = "ClassDecl";

        // ReflectionUtility nutzen, um die Klasse zu laden
        ReflectionUtility reflectionUtility = new ReflectionUtility(sourceFilePath, className);

        // Methoden holen und Konstruktor (falls als Methode generiert) rausfiltern
        List<String> methodNames = reflectionUtility.getMethodNames()
                .stream()
                .filter(name -> !name.equals(className)) // Konstruktorname rausfiltern
                .toList();

        System.out.println("Gefundene Methoden (ohne Konstruktor): " + methodNames);

        // Verifizieren: Es gibt keine echten Methoden, Konstruktoren oder Felder
        assertEquals(1, reflectionUtility.getConstructorCount(), "Eine leere Klasse sollte genau einen Standardkonstruktor haben.");
        assertTrue(reflectionUtility.getFieldNames().isEmpty(), "Es sollten keine Felder vorhanden sein.");
        assertTrue(methodNames.isEmpty(), "Es sollten keine Methoden (außer dem Konstruktor) vorhanden sein.");

        System.out.println("✅ Test für die leere Klasse erfolgreich!");
    }

}