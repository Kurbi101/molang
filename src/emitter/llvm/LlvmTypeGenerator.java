package emitter.llvm;

import types.StructType;
import types.TupleType;
import types.Type;
import types.TypeKind;

import java.util.HashMap;

public class LlvmTypeGenerator {
    private final HashMap<Type, String> llvmTypes;

    public LlvmTypeGenerator() {
        this.llvmTypes = new HashMap<>();
    }

    public String getLlvmType(Type type) {
        if (type.is(TypeKind.Struct)) {
            return "struct." + ((StructType)(type)).getId();
        }
        if (type.is(TypeKind.Tuple)) {
        }
        return this.llvmTypes.get(type);
    }

}