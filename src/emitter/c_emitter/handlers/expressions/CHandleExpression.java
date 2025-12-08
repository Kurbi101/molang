package emitter.c_emitter.handlers.expressions;

import emitter.c_emitter.CEmitter;
import emitter.c_emitter.handlers.statements.CHandleStatement;
import parser.expressions.BinOpNode;
import parser.expressions.ExprNode;
import parser.expressions.FunctionCallNode;
import parser.expressions.IndexAccessNode;
import parser.expressions.MethodCallNode;
import parser.expressions.literals.LiteralNode;
import parser.statements.StatementNode;

public class CHandleExpression extends CHandleStatement {
    public static final StatementNode.StatementKind kind = StatementNode.StatementKind.Expression;

    public static void handle(ExprNode node, CEmitter e) {
        if (node.getWithParentheses()) {
            e.emit("(");
        }
        switch (node.getExprKind()) {
            case BinOp -> CHandleBinOp.handle((BinOpNode) node, e);
            case Literal -> CHandleLiterals.handleLiteral((LiteralNode) node, e);
            case FunctionCall -> CHandleFunctionCall.handle((FunctionCallNode) node, e);
            case MethodCall -> CHandleMethodCall.handle((MethodCallNode) node, e);
            case IndexAccess -> CHandleIndexAccess.handle((IndexAccessNode) node, e);
        }
        if (node.getWithParentheses()) {
            e.emit(")");
        }
    }
}
