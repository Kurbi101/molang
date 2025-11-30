package parser.expressions.literals;

import lexer.tokens.literals.FloatLiteralToken;
import parser.expressions.ExprNode;
import types.FloatType;
import types.Type;

public class FloatLiteralNode extends LiteralNode {

    private final double value;

    public FloatLiteralNode(double value) {
        super(LiteralKind.Float);
        this.value = value;
        this.type = new FloatType();
    }

    public double getValue() {
        return this.value;
    }

    public Type evaluateType() {
        return this.type;
    }
}
