package parser.statements;

import parser.expressions.ExprNode;

public class ReturnNode extends StatementNode {
    private final ExprNode expr;

    public ReturnNode(ExprNode expr) {
        super(StatementKind.Return);
        this.expr = expr;
    }

    public ExprNode getExpr() {
        return this.expr;
    }
}
