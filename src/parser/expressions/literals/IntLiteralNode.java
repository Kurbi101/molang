package parser.expressions.literals;

import parser.expressions.ExprNode;
import types.IntType;
import types.Type;

public class IntLiteralNode extends ExprNode {
    private final int value;

    public IntLiteralNode(int value) {
        this.value = value;
        this.type = new IntType();
    }

    public int getValue() {
        return value;
    }

    public Type evaluateType() {
        return this.type;
    }

}
