package types;

public class FloatType extends Type {

    public enum FloatBits {
        Float32,
        Float64,
    }

    private final FloatBits numBits;

    public FloatType(FloatBits numBits) {
        super(TypeKind.Float);
        this.numBits = numBits;
    }

    public FloatBits getNumBits() {
        return this.numBits;
    }
}
