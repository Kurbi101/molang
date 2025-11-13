package types;


public abstract class Type {

    private final TypeKind kind;

    public Type(TypeKind kind) {
        this.kind = kind;
    }

    public TypeKind getKind() {
        return kind;
    }

    public boolean is(TypeKind other) {
        return this.kind == other;
    }

    public boolean isNot(TypeKind other) {
        return this.kind != other;
    }

    @Override
    public String toString() {
        return "Type(" + this.kind.toString() + ")";
    }

    //TODO: once ASTnode types are defines, there should be a static function for each type that returns a default value

}
