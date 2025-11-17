package types;

public class ArrayType extends Type {

    private final Type internal;
    private final int length;

    public ArrayType(Type elementType, int length) {
        super(TypeKind.Array);
        this.internal = elementType;
        this.length = length;
    }

    @Override
    public String toString() {
        return "ArrayType(" + this.internal + ", " + this.length + ")";
    }

    public Type getInternal() {
        return this.internal;
    }
}
