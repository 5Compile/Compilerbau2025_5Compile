# 5Compile - MiniJava Compiler

Ein Projekt im Rahmen der Vorlesung Compilerbau (SS 2025) an der DHBW Stuttgart.

## 🔍 Ziel

Entwicklung eines vollständigen Compilers für eine reduzierte Java-Teilmenge („MiniJava“) – inklusive Scanning, Parsing, semantischer Analyse und Bytecode-Erzeugung.

## 📦 Technologien

- Java 21
- IntelliJ IDEA
- ANTLR (Parser-Generator)
- ASM 9.8 (Bytecode-Generator)
- Maven
- GitHub
- PlantUML (VS Code Plugin)

## 👨‍💻 Team & Rollen

| Name             | Rolle                  |
|------------------|------------------------|
| Tobias Schuhmacher | Projektleitung          |
| Jonathan Kalmbach | Tester                  |
| Jonas Braun        | Semantische Analyse     |
| Sean Reich         | Scanning / Parsing / Grammatik |
| Bernhard Mebert    | Code-Erzeugung          |

## 🧩 Projektstruktur

- `src/main/antlr/`: ANTLR-Grammatikdateien (`*.g4`)
- `src/main/java/`: Hauptimplementierung
- `src/test/java/`: Tests
- `docs/`: UML, Dokumentation

## 📅 Projektphasen

1. **Initialisierung & ASTold**
   - GitHub-Repo, Projektstruktur, erste Grammatik
2. **Scanning / Parsing**
   - ANTLR-Grammatik, Lexer & Parser, ASTold-Erzeugung
3. **Semantische Analyse**
   - Typprüfung, symbolische Kontextanalyse
4. **Bytecode-Erzeugung**
   - ASM-Integration, Codegenerierung
5. **Integration & Testsuite**
   - JUnit-Tests, Reflections, Fehlerbehandlung
6. **Abschlusspräsentation**
   - Vorstellung des Compilers anhand Test-Suite (27.06.2025)

## 🔍 Projektziel

Ein vollständiger Compiler für MiniJava, der aus einem Java-Subset korrekten Bytecode erzeugt. Dabei liegt der Fokus auf Lernzielen wie:
- Sprachverarbeitung mit ANTLR
- Compilerstruktur verstehen
- Typprüfung & Codegenerierung
- Testmethodik und Tooling

## 📃 Einschränkungen MiniJava

- Keine Vererbung (immer `extends Object`)
- Nur Standardkonstruktoren erlaubt
- Keine Arrays, Threads, Exceptions, Lambda-Expressions
- Nur `int`, `boolean`, `char` als primitive Typen
- Keine Generics, Packages oder Imports
