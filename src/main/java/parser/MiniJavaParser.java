package parser;

import AST.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MiniJavaParser {

    public Program parseFile(String filePath) throws IOException {
        String content = Files.readString(Path.of(filePath));
        return parseContent(content);
    }

    public Program parseContent(String javaCode) {
        // Simple regex-based parsing for basic class structure
        String className = extractClassName(javaCode);
        List<FieldDecl> fields = extractFields(javaCode);
        List<MethodDecl> methods = extractMethods(javaCode);
        Optional<MainMethodDecl> mainMethod = extractMainMethod(javaCode);

        ClassDecl classDecl = new ClassDecl(className, fields, methods, mainMethod);
        return new Program(List.of(classDecl));
    }

    private String extractClassName(String javaCode) {
        Pattern pattern = Pattern.compile("class\\s+(\\w+)\\s*\\{");
        Matcher matcher = pattern.matcher(javaCode);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "DefaultClass";
    }

    private List<FieldDecl> extractFields(String javaCode) {
        List<FieldDecl> fields = new ArrayList<>();
        // Pattern for simple field declarations: type name;
        Pattern pattern = Pattern.compile("(public\\s+|private\\s+|protected\\s+)?(int|boolean|char|\\w+)\\s+(\\w+)\\s*;");
        Matcher matcher = pattern.matcher(javaCode);

        while (matcher.find()) {
            String type = matcher.group(2);
            String name = matcher.group(3);
            fields.add(new FieldDecl(type, name));
        }

        return fields;
    }

    private List<MethodDecl> extractMethods(String javaCode) {
        List<MethodDecl> methods = new ArrayList<>();
        // Pattern for simple method declarations
        Pattern pattern = Pattern.compile("(public\\s+|private\\s+|protected\\s+)?(\\w+)\\s+(\\w+)\\s*\\(([^)]*)\\)\\s*\\{");
        Matcher matcher = pattern.matcher(javaCode);

        while (matcher.find()) {
            String returnType = matcher.group(2);
            String methodName = matcher.group(3);
            String parameters = matcher.group(4);

            // Skip main method
            if ("main".equals(methodName)) {
                continue;
            }

            List<Parameter> paramList = parseParameters(parameters);
            Block body = parseMethodBody(javaCode, methodName);

            methods.add(new MethodDecl(methodName, returnType, paramList, body));
        }

        return methods;
    }

    private Optional<MainMethodDecl> extractMainMethod(String javaCode) {
        Pattern pattern = Pattern.compile("public\\s+static\\s+void\\s+main\\s*\\(\\s*String\\s*\\[\\s*\\]\\s*\\w+\\s*\\)\\s*\\{");
        Matcher matcher = pattern.matcher(javaCode);

        if (matcher.find()) {
            Block body = new Block(Collections.emptyList()); // Empty body for now
            return Optional.of(new MainMethodDecl(body));
        }

        return Optional.empty();
    }

    private List<Parameter> parseParameters(String parameters) {
        List<Parameter> paramList = new ArrayList<>();

        if (parameters == null || parameters.trim().isEmpty()) {
            return paramList;
        }

        String[] params = parameters.split(",");
        for (String param : params) {
            param = param.trim();
            String[] parts = param.split("\\s+");
            if (parts.length >= 2) {
                String type = parts[0];
                String name = parts[1];
                paramList.add(new Parameter(type, name));
            }
        }

        return paramList;
    }

    private Block parseMethodBody(String javaCode, String methodName) {
        List<Statement> statements = new ArrayList<>();

        // Find the method body content
        Pattern methodPattern = Pattern.compile(methodName + "\\s*\\([^)]*\\)\\s*\\{([^}]*)}");
        Matcher methodMatcher = methodPattern.matcher(javaCode);

        if (methodMatcher.find()) {
            String methodBody = methodMatcher.group(1);

            // Parse assignments like: this.field = parameter;
            Pattern assignPattern = Pattern.compile("this\\.(\\w+)\\s*=\\s*(\\w+)\\s*;");
            Matcher assignMatcher = assignPattern.matcher(methodBody);

            while (assignMatcher.find()) {
                String fieldName = assignMatcher.group(1);
                String valueName = assignMatcher.group(2);

                Expression target = new LocalOrFieldVar(fieldName);
                Expression value = new LocalOrFieldVar(valueName);
                statements.add(new Assign(target, value));
            }
        }

        return new Block(statements);
    }
}