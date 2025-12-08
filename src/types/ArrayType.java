package types;

import parser.expressions.ExprNode;

public class ArrayType extends Type {

    private final Type internal;
    private final ExprNode length;

    public ArrayType(Type elementType, ExprNode length) {
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
