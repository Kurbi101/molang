package types;

import parser.Symbol;

public class StructType extends Type {

    private final Symbol id;

    public StructType(Symbol id) {
        super(TypeKind.Struct);
        this.id = id;
    }

    public Symbol getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "StructType(" + this.id + ")";
    }

}
