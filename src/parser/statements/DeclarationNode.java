package parser.statements;

import parser.Symbol;
import parser.expressions.ExprNode;
import types.Type;

public class DeclarationNode extends StatementNode {
    private final Symbol id;
    private final Type type;
    private final ExprNode value;
    private final boolean isConst;

    public static final StatementKind kind = StatementKind.Declaration;

    public DeclarationNode(Symbol id, Type type, ExprNode value, boolean isConst) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.isConst = isConst;
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

    public boolean isConst() {
        return this.isConst;
    }
}
