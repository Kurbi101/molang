package parser.expressions.literals;

import parser.expressions.ExprNode;
import types.BoolType;

import types.Type;

public class BoolLiteralNode extends LiteralNode {

    private final boolean value;

    public BoolLiteralNode(boolean value) {
        super(LiteralKind.Bool);
        this.value = value;
        this.type = new BoolType();
    }

    public boolean getValue() {
        return this.value;
    }

    public Type evaluateType() {
        return this.type;
    }
}
