package AST;

import java.util.List;
import java.util.Optional;

public record ClassDecl(String name,
                        List<FieldDecl> fields,
                        List<MethodDecl> methods,
                        Optional<MainMethodDecl> mainMethod) implements MiniJava {
}
