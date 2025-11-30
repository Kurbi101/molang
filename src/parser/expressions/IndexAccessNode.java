package parser.expressions;

import parser.expressions.literals.IntLiteralNode;
import types.ArrayType;
import types.CharType;
import types.Type;
import types.TypeKind;

public class IndexAccessNode extends ExprNode {
    private final ExprNode callee;
    private final ExprNode index;
    private final Type type;

    public IndexAccessNode(ExprNode callee, ExprNode index) {
        this.callee = callee;
        this.index = index;
        this.type = switch (callee.evaluateType().getKind()) {
            case Array ->  ((ArrayType) callee.evaluateType()).getInternal();
            case Str -> new CharType();
            case Struct -> {
                throw new UnsupportedOperationException("operator overloading for index access not yet available");
            }
            default -> throw new UnsupportedOperationException("operator overloading for index access not yet available for type " + callee.evaluateType().getKind());
        };
    }

    @Override
    public Type evaluateType() {
        return this.type;
    }
}
