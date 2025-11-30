package parser.expressions;

import parser.ASTnode;
import parser.statements.StatementNode;
import types.Type;

public abstract class ExprNode extends StatementNode {
    private static final StatementNode.StatementKind kind = StatementNode.StatementKind.Expression;
    private static final ExprKind exprKind = ExprKind.None;
    protected Type type;

    public enum ExprKind {
        None,
        BinOp,
        Literal,
        FunctionCall,
        MethodCall,
    }

    public ExprKind getExprKind() {
         return exprKind;
    }
    public abstract Type evaluateType();

}
