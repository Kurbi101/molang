package parser.expressions.literals;

import parser.Symbol;
import parser.expressions.ExprNode;
import types.Type;

public class IdentLiteralNode extends ExprNode {
    private final Symbol symbol;
    private final Type type;

    public IdentLiteralNode(Symbol symbol, Type type) {
        this.type = type;
        this.symbol = symbol;
    }

    @Override
    public Type evaluateType() {
        return this.type;
    }
}
