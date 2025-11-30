package parser.expressions.literals;

import parser.expressions.ExprNode;
import types.IntType;
import types.Type;

import static parser.expressions.literals.LiteralNode.LiteralKind.Int;

public class IntLiteralNode extends LiteralNode {
    private final int value;

    public IntLiteralNode(int value) {
        super(Int);
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
