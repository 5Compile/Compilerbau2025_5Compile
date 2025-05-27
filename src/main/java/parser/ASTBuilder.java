package parser;

import AST.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ASTBuilder {

    public Program buildProgram(ParseTree parseTree) {
        // For now, create a simple empty class manually
        // This is a simplified parser - in a real implementation you'd traverse the parse tree
        String input = parseTree.getText();

        // Very basic parsing - just extract class name
        String className = extractClassName(input);
        if (className == null) {
            className = "DefaultClass";
        }

        ClassDecl classDecl = new ClassDecl(
                className,
                Collections.emptyList(), // no fields for now
                Collections.emptyList(), // no methods for now
                Optional.empty() // no main method for now
        );

        return new Program(List.of(classDecl));
    }

    private String extractClassName(String input) {
        // Simple regex-like extraction
        String[] tokens = input.split("\\s+");
        for (int i = 0; i < tokens.length - 1; i++) {
            if ("class".equals(tokens[i])) {
                String candidate = tokens[i + 1];
                // Remove any trailing { if present
                if (candidate.endsWith("{")) {
                    candidate = candidate.substring(0, candidate.length() - 1);
                }
                return candidate;
            }
        }
        return null;
    }
}