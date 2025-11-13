package parser.expressions.literals;

import parser.expressions.ExprNode;
import types.StrType;
import types.Type;

public class StringLiteralNode extends ExprNode {

    private final String value;

    public StringLiteralNode(String value) {
        this.value = value;
        this.type = new StrType();
    }

    public String getValue() {
        return this.value;
    }

    public Type evaluateType() {
        return this.type;
    }
}
