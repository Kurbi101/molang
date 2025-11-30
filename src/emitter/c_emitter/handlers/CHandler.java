package emitter.c_emitter.handlers;

import emitter.EmitterHandler;
import types.ArrayType;
import types.StructType;
import types.Type;

public abstract class CHandler implements EmitterHandler {

    protected static String toCType(Type type) {
        return switch (type.getKind()) {
            case Int -> "int";
            case Float -> "float";
            case Bool -> "bool";
            case Str -> "str";
            case Void -> "void";
            case Array -> {
                ArrayType arrayType = (ArrayType) type;
                yield "*" + toCType(arrayType.getInternal());
            }
            case Struct -> {
                StructType structType = (StructType) type;
                yield structType.getId() + "*";
            }
            default -> {
                throw new UnsupportedOperationException("Unsupported type: " + type.getKind() + " in c emitter");
            }
        };
    }
}
