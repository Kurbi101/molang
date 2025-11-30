package parser.statements;

import parser.expressions.ExprNode;

public class ReturnNode extends StatementNode {
    private final ExprNode expr;
    public static final StatementKind kind = StatementKind.Return;

    public ReturnNode(ExprNode expr) {
        this.expr = expr;
    }

    public ExprNode getExpr() {
        return this.expr;
    }
}
