package codegen;

public class Type {
    public enum Kind {
        INT, BOOL, CHAR, VOID, REFERENCE
    }

    private final Kind kind;
    private final String reference;

    public Type(Kind kind) {
        this.kind = kind;
        this.reference = null;
    }

    public Type(Kind kind, String reference) {
        this.kind = kind;
        this.reference = reference;
    }

    public static Type INT = new Type(Kind.INT);
    public static Type BOOL = new Type(Kind.BOOL);
    public static Type CHAR = new Type(Kind.CHAR);
    public static Type VOID = new Type(Kind.VOID);

    public static Type reference(String className) {
        return new Type(Kind.REFERENCE, className);
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

    public Kind getKind() {
        return kind;
    }

    public String getReference() {
        return reference;
    }

    public static Type fromString(String typeStr) {
        return switch (typeStr) {
            case "int" -> INT;
            case "boolean" -> BOOL;
            case "char" -> CHAR;
            case "void" -> VOID;
            default -> reference(typeStr);
        };
    }
}