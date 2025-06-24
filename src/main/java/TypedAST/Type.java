package TypedAST;

import lombok.Data;

@Data
public class Type {
    public enum Kind {
        INT,
        BOOL,
        CHAR,
        VOID,
        REFERENCE
    }
    
    private final Kind kind;
    private final String reference;
    
    private Type(Kind kind, String reference) {
        this.kind = kind;
        this.reference = reference;
    }
    
    // Static instances for primitive types
    public static final Type INT = new Type(Kind.INT, null);
    public static final Type BOOL = new Type(Kind.BOOL, null);
    public static final Type CHAR = new Type(Kind.CHAR, null);
    public static final Type VOID = new Type(Kind.VOID, null);
    
    // Factory method for reference types
    public static Type REFERENCE(String reference) {
        return new Type(Kind.REFERENCE, reference);
    }
    
    public String getDescriptor() {
        return switch (kind) {
            case INT -> "I";
            case BOOL -> "Z";
            case CHAR -> "C";
            case VOID -> "V";
            case REFERENCE -> "L" + reference + ";";
        };
    }
    
    public static Type fromDescriptor(String descriptor) {
        return switch (descriptor) {
            case "I" -> INT;
            case "Z" -> BOOL;
            case "C" -> CHAR;
            case "V" -> VOID;
            default -> {
                if (descriptor.startsWith("L") && descriptor.endsWith(";")) {
                    // Extract class name from descriptor "LClassName;"
                    String className = descriptor.substring(1, descriptor.length() - 1);
                    yield REFERENCE(className);
                }
                throw new IllegalArgumentException("Unknown type descriptor: " + descriptor);
            }
        };
    }
    
    // Convenience methods for type checking
    public boolean isPrimitive() {
        return kind != Kind.REFERENCE;
    }
    
    public boolean isReference() {
        return kind == Kind.REFERENCE;
    }
    
    public String getReferenceName() {
        if (kind != Kind.REFERENCE) {
            throw new IllegalStateException("Not a reference type");
        }
        return reference;
    }
    
    @Override
    public String toString() {
        return switch (kind) {
            case INT -> "int";
            case BOOL -> "bool";
            case CHAR -> "char";
            case VOID -> "void";
            case REFERENCE -> reference;
        };
    }
}
