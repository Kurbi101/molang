package parser.expressions.literals;

import parser.expressions.ExprNode;
import types.CharType;
import types.Type;

public class CharLiteralNode extends LiteralNode {

    private final char value;

    public CharLiteralNode(char value) {
        super(LiteralKind.Char);
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
