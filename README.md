# 5Compile - MiniJava Compiler

Ein Projekt im Rahmen der Vorlesung Compilerbau (SS 2025) an der DHBW Stuttgart.

## Ziel

Entwicklung eines vollständigen Compilers für eine reduzierte Java-Teilmenge („MiniJava“) – inklusive Scanning, Parsing, semantischer Analyse und Bytecode-Erzeugung.

Dabei liegt der Fokus auf Lernzielen wie:
- Sprachverarbeitung mit ANTLR
- Compilerstruktur verstehen
- Typprüfung & Codegenerierung
- Testmethodik und Tooling

## Team & Rollen

| Name               | Rolle                          | E-Mail-Alias |
|--------------------|--------------------------------|--------------|
| Tobias Schuhmacher | Projektleitung                 | i23036@...   |
| Jonathan Kalmbach  | Tester                         | i23018@...   |
| Jonas Braun        | Semantische Analyse            | i23007@...   |
| Sean Reich         | Scanning / Parsing / Grammatik | i23031@...   |
| Bernhard Mebert    | Code-Erzeugung                 | i23022@...   |

## Tech-Stack

- Java 21
- IntelliJ IDEA
- ANTLR (Parser-Generator)
- ASM 9.8 (Bytecode-Generator)
- Maven
- Lombok
- GitHub (Repo)
- PlantUML (VS Code Plugin)

## Projektstruktur

- `src/main/antlr/`: ANTLR-Grammatik (`*.g4`)
- `src/main/java/`: Hauptimplementierung
- `src/test/java/`: Tests
- `docs/`: UML, Dokumentation

##  Projektphasen

1. **Initialisierung**

   - GitHub-Repo aufsetzen, Projektstruktur anlegen

2. **AST- und Schnittstellendefinition**

   - Gemeinsame Festlegung des abstrakten Syntaxbaums (AST) und der zentralen Interfaces

3. **Erste vollständige Kompilierung**

   - Ziel: Eine leere Klasse erfolgreich durch alle Phasen (Parse → Typisierung → Bytecode) bringen

4. **Testgetriebene Feature-Entwicklung**

   - Aufbau einer Testsuite, die schrittweise um Sprachfeatures erweitert wurde
   - Entwickler konnten sich unabhängig an den Tests orientieren

5. **Fehlerbehandlung**

   - Prüfungen auf ungültige Eingaben und Fehlersammlung

6. **Vorbereitung Präsentation**

   - Spezielle Testfälle, vollständige Integration, Live-Demo-Vorbereitung

7. **Abschlusspräsentation**

   - Vorstellung des Compilers und der einzelnen Teilbereiche (27.06.2025)
