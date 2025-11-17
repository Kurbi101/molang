package parser.statements;

import parser.Symbol;
import parser.expressions.ExprNode;
import types.Type;

public class DefinitionNode extends StatementNode {
    private Symbol id;
    private Type type;
    private ExprNode value;

    public DefinitionNode(Symbol id, Type type, ExprNode value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    public Symbol getId() {
        return this.id;
    }

    public Type getType() {
        return this.type;
    }

    public ExprNode getValue() {
        return this.value;
    }
}
