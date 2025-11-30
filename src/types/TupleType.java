package types;

import java.util.ArrayList;

public class TupleType extends Type {
    ArrayList<Type> internalTypes;

    public TupleType(ArrayList<Type> internalTypes) {
        super(TypeKind.Tuple);
        this.internalTypes = internalTypes;
    }

}
