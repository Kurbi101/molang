package types;

public class IntType extends Type {

    /*
     * bit number must be rising in ordinal values.
     */
    public enum IntBits {
        Int8,
        Int16,
        Int32,
        Int64,
        Int128,
    }

    private final boolean isSigned;
    private final IntBits numBits;

    public IntType(boolean isSigned, IntBits numBits) {
        super(TypeKind.Int);
        this.isSigned = isSigned;
        this.numBits = numBits;
    }

    public IntType() {
        this(true, IntBits.Int64);
    }

    public boolean isSigned() {
        return this.isSigned;
    }

    public IntBits getNumBits() {
        return this.numBits;
    }

}
