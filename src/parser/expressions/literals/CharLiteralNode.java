package parser.expressions.literals;

import parser.expressions.ExprNode;
import types.CharType;
import types.Type;

public class CharLiteralNode extends ExprNode {

    private final char value;

    public CharLiteralNode(char value) {
        this.value = value;
        this.type = new CharType();
    }

    public char getValue() {
        return this.value;
    }

    public Type evaluateType() {
        return this.type;
    }
}
