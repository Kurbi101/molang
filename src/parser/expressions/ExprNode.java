package parser.expressions;

import parser.ASTnode;
import parser.statements.StatementNode;
import types.Type;

public abstract class ExprNode extends StatementNode {
    protected ExprKind exprKind = ExprKind.None;
    protected Type type;
    protected boolean withParentheses = false;

    public ExprNode() {
        super(StatementNode.StatementKind.Expression);
    }

    public enum ExprKind {
        None,
        BinOp,
        Literal,
        FunctionCall,
        MethodCall,
        IndexAccess,
    }

    public void setWithParentheses() {
        this.withParentheses = true;
    }

    public boolean getWithParentheses() {
        return this.withParentheses;
    }

    public ExprKind getExprKind() {
         return this.exprKind;
    }
    public abstract Type evaluateType();

}
