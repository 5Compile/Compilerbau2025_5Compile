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
